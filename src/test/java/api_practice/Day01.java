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


    @DisplayName("Get with english letters")
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

    @DisplayName("Get with russian letters")
    @Test
    public void TestGet2() {
        given()
                .log().all()
                .formParam("name", "Аня").
        when()
                .get("/hello").
        then()
                .log().all()
                .statusCode(is(200))
                .assertThat().contentType("application/json")
        ;

    }

    @DisplayName("Get with english letters and numbers")
    @Test
    public void TestGet3() {
        given()
                .log().all()
                .formParam("name", "Ana123").
        when()
                .get("/hello").
        then()
                .log().all()
                .statusCode(is(200))
                .assertThat().contentType("application/json")
        ;

    }

    @DisplayName("Get with empty name")
    @Test
    public void TestGet4() {
        given()
                .log().all()
                .formParam("name", "").
        when()
                .get("/hello").
        then()
                .log().all()
                .statusCode(is(200))
                .assertThat().contentType("application/json")
        ;

    }

    @DisplayName("Get with without param name")
    @Test
    public void TestGet5() {
        given()
                .log().all().
        when()
                .get("/hello").
        then()
                .log().all()
                .statusCode(is(200))
                .assertThat().contentType("application/json")
        ;

    }

}
