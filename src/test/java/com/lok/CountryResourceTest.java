package com.lok;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class CountryResourceTest {

    @Test
    public void testCountryEndpoint() {
        given()
                .auth().oauth2(Tokens.ADMIN_TOKEN)
                .when().get("/api/v1/countries?field_name=states")
                .then()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo(Boolean.TRUE));
    }

}