package APITestOtomasyonu.Tests;
//22 derse geldim.

import APITestOtomasyonu.baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C22_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {
    /*
        https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini yazarak “firstname”
        degeri “Susan” ve “lastname” degeri “Jones” olan rezervasyon oldugunu test edecek bir GET request
        gonderdigimizde, donen response’un status code’unun 200 oldugunu ve “Susan Jones” ismine sahip en az
        bir booking oldugunu test edin.
    */

    @Test
    public void C22_BaseUrlHerokuappQueryParam(){
        //1 - Request url ve body olustur.
        specHerokuapp.pathParam("pp1", "booking")
                .queryParams("firstname", "Jane", "lastname", "Doe");

        //2 - Soruda varsa expected data olustur.
        //3 - Response olustur, request gonderip sonucu response'i ata.
        Response response = given().spec(specHerokuapp).when().get("{pp1}");
        response.prettyPrint();

        //4 - Assertion.
        response.then()
                .assertThat()
                .statusCode(200).body("bookingid", hasSize(greaterThan(10)));

    }

}
