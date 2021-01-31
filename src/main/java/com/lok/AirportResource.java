package com.lok;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Objects;

@Path("/single")
public class AirportResource {

    @Operation(summary = "Get the airport with its IATA code"
            , deprecated = false)
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Found the airport",
                    content = {@Content(mediaType = "application/json")}),
            @APIResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @APIResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content),
            @APIResponse(responseCode = "403", description = "Forbidden",
                    content = @Content),
            @APIResponse(responseCode = "404", description = "Not found",
                    content = @Content)})
    @GET
    @RolesAllowed("admin")
    @SecurityRequirement(name = "Authorization", scopes = {})
    @Produces(MediaType.APPLICATION_JSON)
    public String getAirports(
            @Parameter(
                    name = "iata",
                    description = "The 3 character airport code. This code can be retrieved using our multi-airport api request.",
                    required = true)
            @QueryParam("iata") String iata) {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofSeconds(60))
                .build();
        String url = Constants.API_URL.concat("/single");
        if (Objects.nonNull(iata) && !iata.isEmpty()) {
            url = url.concat("?iata=" + iata);
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers
                        .ofString(""))
                .headers("APC-Auth", Constants.APC_Auth,
                        "APC-Auth-Secret", Constants.APC_AUTH_SECRET,
                        "Content-Type", "application/json",
                        "Accept", "application/json")
                .build();
        HttpResponse response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return (String) response.body();
    }
}