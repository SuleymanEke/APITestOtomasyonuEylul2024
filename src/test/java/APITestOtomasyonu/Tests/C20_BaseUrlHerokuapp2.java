package APITestOtomasyonu.Tests;
//22 derse geldim.

import APITestOtomasyonu.baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C20_BaseUrlHerokuapp2 extends BaseUrlHerokuapp {
    /*
        https://restful-booker.herokuapp.com/booking
        endpointine yandaki body’ye sahip bir POST request gonderdigimizde donen response’un
        status code’unun 200 oldugunu ve “firstname” degerinin “Ahmet” oldugunu test edin.

                {
                "firstname" : "Recep",
                "lastname" : “Ivedik",
                "totalprice" : 369,
                "depositpaid" : false,
                "bookingdates" : {
                "checkin" : "2021-06-01",
                "checkout" : "2021-06-10"
                },
                "additionalneeds" : "Bu ne saçma hayat, bu ne serkeş hayat, bu ne dingil hayat ya? Bu ne kopuk hayat, bu ne manyak yaşam tarzı ya, bu ne bohem ya?"
                }
     */
    @Test
    public void C20_BaseUrlHerokuapp2() {
        //1 - Request Body ve End-Point hazirlama.
        specHerokuapp.pathParam("pp1", "booking");

        JSONObject requestBody = new JSONObject();
        JSONObject bookingDatesJson = new JSONObject();

        bookingDatesJson.put("checkin", "2021-06-01");
        bookingDatesJson.put("checkout", "2021-06-10");

        requestBody.put("firstname", "Recep");
        requestBody.put("lastname", "Ivedik");
        requestBody.put("totalprice", 369);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates", bookingDatesJson);
        requestBody.put("additionalneeds", "Bu ne saçma hayat, bu ne serkeş hayat, bu ne dingil hayat ya? Bu ne kopuk hayat, bu ne manyak yaşam tarzı ya, bu ne bohem ya?");

        //2 - Expected Data hazirlama.
        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given().spec(specHerokuapp).when().body(requestBody.toString()).post("{pp1}");
        response.prettyPrint();

        //4 - Assertion.
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("booking.firstname", equalTo("Recep"));



    }

}
