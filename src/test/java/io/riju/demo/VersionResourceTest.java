package io.riju.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class VersionResourceTest {

    @Test
    void testColorEndpoint() {
        given()
          .when().get("/version")
          .then()
             .statusCode(200);
    }
}