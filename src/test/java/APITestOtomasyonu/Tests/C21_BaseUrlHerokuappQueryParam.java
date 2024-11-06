package APITestOtomasyonu.Tests;

import APITestOtomasyonu.baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C21_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {
     /*
        https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini yazarak “firstname”
        degeri “Eric” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin.
     */

    @Test
    public void C21_BaseUrlHerokuappQueryParam(){
        //1 - Request url ve body olustur.
        specHerokuapp.pathParam("pp1", "booking")
                .queryParam("firstname", "Susan");

        //2 - Soruda varsa expected data olustur.
        //3 - Response olustur, request gonderip sonucu response'i ata.
        Response response = given().spec(specHerokuapp).when().get("{pp1}");
        response.prettyPrint();

        //4 - Assertion.
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(2));

    }

}
