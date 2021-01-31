package com.lok;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class AirportResourceTest {

    @Test
    public void testHelloEndpoint() {

        given()
                .auth().oauth2(Tokens.ADMIN_TOKEN)
                .when().get("/api/v1/single?iata=JKF")
                .then()
                .statusCode(200);
    }

}