package com.lok;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lok.pojo.ResponseJson;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.util.Objects;

@Provider
public class ResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ResponseJson responseJson = gson.fromJson((String) responseContext.getEntity(), ResponseJson.class);
        if(Objects.nonNull(responseJson) && !responseJson.isValidResponse())
            responseContext.setStatus(responseJson.getStatusCode());
    }
}
