package com.lok;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class CountryResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/v1/countries?field_name=states")
          .then()
             .statusCode(200);
    }

}