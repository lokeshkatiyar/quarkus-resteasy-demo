package com.lok;


import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/v1")
@SecurityScheme(securitySchemeName = "Authorization", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "jwt")
@OpenAPIDefinition(
        tags = {
                @Tag(name="default")
        },
        info = @Info(
                title="Rest API Demo",
                version = "1.0.1",
                contact = @Contact(
                        name = "Quarkus RestEasy Demo",
                        email = "lokeshkatiyar@yahoo.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class ApplicationContext extends Application {

}
