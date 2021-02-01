package com.lok;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class AirportResourceTest {

    @Test
    public void testAirportEndpoint() {
        RestAssured.defaultParser = Parser.JSON;
        given()
                .auth().oauth2(Tokens.ADMIN_TOKEN)
                .when().get("/api/v1/single?iata=JKF")
                .then()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo(Boolean.TRUE));
    }

}