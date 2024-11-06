package APITestOtomasyonu.Tests;

import APITestOtomasyonu.baseUrl.BaseUrlHerokuapp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlHerokuapp extends BaseUrlHerokuapp {
        /*
        https://restful-booker.herokuapp.com/booking endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve Response’ta 12 booking oldugunu test edin.
        */


    @Test
    public void C19_BaseUrlHerokuapp() {
        //1 - Request Body ve End-Point hazirlama.
        specHerokuapp.pathParam("pp1", "booking");

        //2 - Expected Data hazirlama.
        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given().spec(specHerokuapp).when().get("{pp1}");
        //response.prettyPrint();

        //4 - Assertion.
        JsonPath responseJson = response.jsonPath();
        System.out.println("BookingId: " + responseJson.getList("bookingid").size());
        response
                .then()
                .assertThat()
                .statusCode(200);

    }

}
//21. 09.45'e geldim.


