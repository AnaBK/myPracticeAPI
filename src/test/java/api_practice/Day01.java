package api_practice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.* ;

public class Day01 {


    @BeforeAll
    public static void setUp() {
        baseURI = "https://playground.learnqa.ru";
        basePath = "/ajax/api";
    }

    @AfterAll
    public static void tearDown() {
        reset();
    }


    @DisplayName(" Test")
    @Test
    public void TestGet1() {
       given()
                .log().all()
                .formParam("name", "Ana").
       when()
                .get("/hello").
       then()
               .log().all()
               .statusCode(is(200))
               .assertThat().contentType("application/json")
       ;

    }

}
