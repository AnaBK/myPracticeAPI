package api_practice.day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.*;

import static io.restassured.RestAssured.*;

public class Day03_Triangle {

    @DisplayName("GET треугольник")
    @Test
    public void TestGet1() {
    Response response1 =
        given()
                .param("a", 4)
                .param("b", 4)
                .param("c", 5)
                .log().all().
        when()
                .get("https://playground.learnqa.ru/ajax/puzzle/triangle");

        JsonPath jp = response1.jsonPath();
        Map<String, Object> responseMap1 = jp.getMap("");
        System.out.println("равнобедренный треугольник = " + responseMap1);


        Response response2 =
                given()
                        .param("a", 4)
                        .param("b", 2)
                        .param("c", 5)
                        .log().all().
                        when()
                        .get("https://playground.learnqa.ru/ajax/puzzle/triangle");

        JsonPath jp2 = response2.jsonPath();
        Map<String, Object> responseMap2 = jp2.getMap("");
        System.out.println("тупоугольный треугольник = " + responseMap2);

        Response response4 =
                given()
                        .param("a", 4)
                        .param("b", 4)
                        .param("c", 4)
                        .log().all().
                        when()
                        .get("https://playground.learnqa.ru/ajax/puzzle/triangle");

        JsonPath jp4 = response4.jsonPath();
        Map<String, Object> responseMap4 = jp4.getMap("");
        System.out.println("равносторонний треугольник = " + responseMap4);

        Response response5 =
                given()
                        .param("a", 4)
                        .param("b", 6)
                        .param("c", 5)
                        .log().all().
                        when()
                        .get("https://playground.learnqa.ru/ajax/puzzle/triangle");

        JsonPath jp5 = response5.jsonPath();
        Map<String, Object> responseMap5 = jp5.getMap("");
        System.out.println("остроугольный треугольник = " + responseMap5);

        Response response3 =
                given()
                        .param("a", 3)
                        .param("b", 4)
                        .param("c", 5)
                        .log().all().
                        when()
                        .get("https://playground.learnqa.ru/ajax/puzzle/triangle");

        JsonPath jp3 = response3.jsonPath();
        Map<String, Object> responseMap3 = jp3.getMap("");
        System.out.println("прямоугольный треугольник = " + responseMap3);


        Response response6 =
                given()
                        .param("a", 4)
                        .param("b", 4)
                        .log().all().
                        when()
                        .get("https://playground.learnqa.ru/ajax/puzzle/triangle");

        JsonPath jp6 = response6.jsonPath();
        Map<String, Object> responseMap6 = jp6.getMap("");
        System.out.println(responseMap6);

        Response response7 =
                given()
                        .param("b", 4)
                        .param("c", 1)
                        .log().all().
                        when()
                        .get("https://playground.learnqa.ru/ajax/puzzle/triangle");

        JsonPath jp7 = response7.jsonPath();
        Map<String, Object> responseMap7 = jp7.getMap("");
        System.out.println(responseMap7);

        Response response8 =
                given()
                        .param("a", 9)
                        .param("m", 3)
                        .param("c", 3)
                        .log().all().
                        when()
                        .get("https://playground.learnqa.ru/ajax/puzzle/triangle");

        JsonPath jp8 = response8.jsonPath();
        Map<String, Object> responseMap8 = jp8.getMap("");
        System.out.println(responseMap8);


        Response response9 =
                given()
                        .log().all().
                        when()
                        .get("https://playground.learnqa.ru/ajax/puzzle/triangle");

        JsonPath jp9 = response9.jsonPath();
        Map<String, Object> responseMap9 = jp9.getMap("");
        System.out.println(responseMap9);

        Response response10 =
                given()
                        .log().all()
                        .param("a", 0)
                        .param("b", 0)
                        .param("c", 0).
                when()
                        .get("https://playground.learnqa.ru/ajax/puzzle/triangle");

        JsonPath jp10 = response10.jsonPath();
        Map<String, Object> responseMap10 = jp10.getMap("");
        System.out.println(responseMap10);




    }





}
