package api_practice.day02;

import io.restassured.filter.cookie.CookieFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static io.restassured.RestAssured.*;

public class Day02_ReadFromFile {

    private static String cookies;
    private static String[] passwords;

    @BeforeAll
    public static void setUp() {
        baseURI = "https://playground.learnqa.ru";
        basePath = "/ajax/api";
    }

    @AfterAll
    public static void tearDown() {
        reset();
    }


    @DisplayName("POST /get_auth_cookie ")
    @Test
    public void TestGet1() throws FileNotFoundException {

            String path = "passwords.txt";
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            ArrayList<String> list = new ArrayList<>();
            while(scanner.hasNext()){
                list.add(scanner.nextLine());
            }
            passwords = new String[list.size()];
            passwords = list.toArray(passwords);

        Response response = given()
                .log().all()
                .queryParam("login", "super_admin")
                .queryParam("password", Arrays.toString(passwords))
                .contentType(ContentType.TEXT)
        .when()
                .post("/get_auth_cookie")
        .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.cookie("auth_cookie"));
        cookies = response.detailedCookies().toString();


    }

    @DisplayName("POST /check_auth_cookie ")
    @Test
    public void TestGet2() {
        given()
                .log().all()
                .cookie("auth_cookie", cookies)
        .when()
                .post("/check_auth_cookie")
        .then()
                .log().all()
                .log().headers()
                .statusCode(200)
        ;



    }

}

