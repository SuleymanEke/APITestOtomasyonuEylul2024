package APITestOtomasyonu.Tests;
//17. ders.

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {
    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
    request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.

    Response Body:
    {
            "booking": {
                "firstname": "Recep",
                "lastname": "Ivedik",
                "totalprice": 3169,
                "depositpaid": false,
                "bookingdates": {
                    "checkin": "2023-01-10",
                    "checkout": "2023-01-20"
                },
                "additionalneeds": "Lan ikiz dingiller, o dilini koparritim senin!"
            }

     */
    @Test
    public void C14_Post_ExpectedDataVeJsonPathIleAssertion() {
        //1 - Request Body ve End-Point hazirlama.
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody = new JSONObject();
        JSONObject rezTarihleriJson = new JSONObject();

        rezTarihleriJson.put("checkin", "2023-01-10");
        rezTarihleriJson.put("checkout", "2023-01-20");

        requestBody.put("firstname", "Recep");
        requestBody.put("lastname", "Ivedik");
        requestBody.put("totalprice", 3169);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates", rezTarihleriJson);
        requestBody.put("additionalneeds", "Lan ikiz dingiller, o dilini koparritim senin!");

        //2 - Expected Data hazirlama.

        JSONObject expectedData = new JSONObject();
        expectedData.put("bookingid", 24);
        expectedData.put("booking", requestBody);

        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .post(url);

        //4 - Assertion.

        JsonPath responseJsonPath = response.jsonPath();
        assertEquals(expectedData.getJSONObject("booking").get("firstname"), responseJsonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"), responseJsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"), responseJsonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"), responseJsonPath.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                responseJsonPath.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                responseJsonPath.get("booking.bookingdates.checkout"));


    }


}
