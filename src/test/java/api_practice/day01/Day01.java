package api_practice.day01;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.* ;

public class Day01 {

    static String url = "/ajax/api";
    static String url_dev = "/ajax/api_dev";

    //https://playground.learnqa.ru/ajax/api_dev/hello

    @BeforeAll
    public static void setUp() {
        baseURI = "https://playground.learnqa.ru";

    }

    @AfterAll
    public static void tearDown() {
        reset();
    }


    @DisplayName("GET with english letters")
    @Test
    public void TestGet1() {
       given()
                .log().all()
                .formParam("name", "Ana").
       when()
                .get(url + "/hello").
       then()
               .log().all()
               .statusCode(is(200))
               .assertThat().contentType("application/json")
       ;

    }

    @DisplayName("GET with russian letters")
    @Test
    public void TestGet2() {
        given()
                .log().all()
                .formParam("name", "Аня").
        when()
        .get(url + "/hello").
        then()
                .log().all()
                .statusCode(is(200))
                .assertThat().contentType("application/json")
        ;

    }

    @DisplayName("GET with english letters and numbers")
    @Test
    public void TestGet3() {
        given()
                .log().all()
                .formParam("name", "Ana123").
        when()
                .get(url + "/hello").
        then()
                .log().all()
                .statusCode(is(200))
                .assertThat().contentType("application/json")
        ;

    }

    @DisplayName("GET with empty name")
    @Test
    public void TestGet4() {
        given()
                .log().all()
                .formParam("name", "").
        when()
                .get(url + "/hello").
        then()
                .log().all()
                .statusCode(is(200))
                .assertThat().contentType("application/json")
        ;

    }

    @DisplayName("GET with without param name")
    @Test
    public void TestGet5() {
        given()
                .log().all().
        when()
                .get(url + "/hello").
        then()
                .log().all()
                .statusCode(is(200))
                .assertThat().contentType("application/json")
        ;

    }


    @DisplayName("GET with english letters")
    @Test
    public void TestGet6() {
        given()
                .log().all()
                .formParam("name", "Ana").
                when()
                .get(url_dev + "/hello").
                then()
                .log().all()
                .statusCode(is(200))
                .assertThat().contentType("application/json")
        ;

    }

    @DisplayName("GET with russian letters")
    @Test
    public void TestGet7() {
        given()
                .log().all()
                .formParam("name", "Аня").
                when()
                .get(url_dev + "/hello").
                then()
                .log().all()
                .statusCode(is(200))
                .assertThat().contentType("application/json")
        ;

    }

    @DisplayName("GET with english letters and numbers")
    @Test
    public void TestGet8() {
        given()
                .log().all()
                .formParam("name", "Ana123").
                when()
                .get(url_dev + "/hello").
                then()
                .log().all()
                .statusCode(is(200))
                .assertThat().contentType("application/json")
        ;

    }

    @DisplayName("GET with empty name")
    @Test
    public void TestGet9() {
        given()
                .log().all()
                .formParam("name", "").
                when()
                .get(url_dev + "/hello").
                then()
                .log().all()
                .statusCode(is(200))
                .assertThat().contentType("application/json")
        ;

    }

    @DisplayName("GET with without param name")
    @Test
    public void TestGet10() {
        given()
                .log().all().
                when()
                .get(url_dev + "/hello").
                then()
                .log().all()
                .statusCode(is(200))
                .assertThat().contentType("application/json")
        ;

    }



}
