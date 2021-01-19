package api_practice.day02;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import static io.restassured.RestAssured.*;
import static org.apache.poi.ss.usermodel.Cell.*;
import static org.apache.poi.ss.usermodel.Workbook.*;
import static org.hamcrest.Matchers.* ;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Day02_Credentials {

//    Сегодня к нам пришел наш коллега и сказал, что забыл свой пароль от важного сервиса. Он просит нас помочь ему написать программу, которая подберет его пароль.
//
//Условие следующее. Есть метод: https://playground.learnqa.ru/ajax/api/get_auth_cookie
//Его необходимо вызывать с двумя POST-параметрами: login и password
//
//Если вызвать метод без поля login или указать несуществующий login, метод вернет 500
//Если login указан и существует, метод вернет нам авторизационную cookie с названием auth_cookie и каким-то значением.
//Но есть нюанс. У метода существует защита от перебора. Если верно указано поле login, но передан неправильный password, то авторизационная cookie все равно вернется.
// НО с "неправильным" значением, которое на самом деле не позволит авторизоваться. Только в том случае, если и login, и password указаны верно, вернется cookie с "правильным" значением.
// Таким образом используя только метод get_auth_cookie невозможно узнать, передали ли мы верный пароль или нет.
//
//По этой причине нам потребуется второй метод. Чтобы проверить, вернулась ли нам cookie с "правильным" значением, существует метод https://playground.learnqa.ru/ajax/api/check_auth_cookie
//Если вызвать его без cookie с названием auth_cookie или вызвать его с cookie, у которой выставлено "неправильное" значение, метод вернет фразу "You are NOT authorized".
//Только если передать cookie с правильным значением, метод вернет другую фразу, которая содержит в себе секретный код.
//
//Коллега говорит, что точно помнит свой login - это значение super_admin
//А вот пароль забыл, но точно помнит, что выбрал его из списка самых популярных паролей на Википедии (вот тебе и супер админ...) по ссылке
// https://en.wikipedia.org/wiki/List_of_the_most_common_passwords
//Искать его нужно среди списка Top 25 most common passwords by year according to SplashData
//
//Итак, наша задача - написать программу (тест) и передать ей login нашего коллеги и все пароли из списка Википедии.
// Программа должна делать следующее - брать очередной пароль и вместе с логином коллеги вызывать первый метод get_auth_cookie.
// В ответ метод будет возвращать авторизационную cookie с именем auth_cookie и каким-то значением. Далее эту cookie мы должна передать во второй метод check_auth_cookie.
// Если в ответ вернулась фраза "You are NOT authorized", значит пароль неправильный. В этом случае берем следующий пароль и все заново. Если же вернулась другая фраза - нужно,
// чтобы программа вывела верный пароль и эту фразу.
//
//Как всегда, код нашей программы выкладываем ссылкой в поле "Ссылка на коммит или файл на облаке"
//А правильный пароль и секретную фразу, которая возвращается при вызове метода check_auth_cookie с правильной cookie - в поле "Ответ"


    private static String inputFile;

    @BeforeAll
    public static void setUp() throws IOException {
        baseURI = "https://playground.learnqa.ru";
        basePath = "/ajax/api";
    }

    @AfterAll
    public static void tearDown() {
        reset();
    }


    @DisplayName("POST")
    @Test
    public void TestGet1() {

//        String path = "C:\\Users\\lien8\\Desktop\\passwords.xlsx";
//        NewExcel test = new NewExcel();
//        test.setInputFile("C:\\Users\\lien8\\Desktop\\passwords.xlsx");
//        test.read();

        given()
                .log().all()
                        .queryParam("login", "super_admin")
                        .queryParams("password", "")
                .contentType(ContentType.TEXT)
        .when()
                .post("/get_auth_cookie")
        .then()
                .statusCode(200)
                .extract()
                .response()
                .getDetailedCookies()
        ;

    }

}
