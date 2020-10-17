package io.riju.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class ColorResourceTest {

    @Test
    void testColorEndpoint() {
        given()
          .when().get("/color")
          .then()
             .statusCode(200);
    }

}