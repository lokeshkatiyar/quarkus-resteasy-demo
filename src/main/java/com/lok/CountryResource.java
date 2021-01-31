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

@Path("/countries")
public class CountryResource {
    @Operation(summary = "Returns a list of all countries"
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
    @RolesAllowed("user")
    @SecurityRequirement(name = "Authorization", scopes = {})
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountries(
            @Parameter(
                    name = "field_name",
                    description = "The name of the input/select field",
                    required = false)
            @QueryParam("field_name") String field_name) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofSeconds(60))
                .build();
        String url = Constants.API_URL.concat("/countries");
        if(Objects.nonNull(field_name)){
            url = url.concat("?field_name="+ field_name);
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .headers("APC-Auth", Constants.APC_Auth,
                        "APC-Auth-Secret",Constants.APC_AUTH_SECRET,
                        "Content-Type","application/json" ,
                        "Accept","application/json")
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
}