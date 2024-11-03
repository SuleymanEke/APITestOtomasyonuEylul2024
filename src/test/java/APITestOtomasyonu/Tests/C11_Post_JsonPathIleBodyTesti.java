package APITestOtomasyonu.Tests;
//15. ders.

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class C11_Post_JsonPathIleBodyTesti {
    /*
    {
        "firstname" : "Recep",
        "lastname" : "Ivedik",
        "totalprice" : 3169,
        "depositpaid" : false,
        "bookingdates" : {
        "checkin" : "2023-01-10",
        "checkout" : "2023-01-20"
        },
        "additionalneeds" : "Testesteronlarım!"
        }

        donen Response’un,
        status code’unun 200,
        ve content type’inin application-json, ve response body’sindeki
        "firstname“in,"Ahmet",
        ve "lastname“in, "Bulut",
        ve "totalprice“in,500,
        ve "depositpaid“in,false,
        ve "checkin" tarihinin 2023-01-10
        ve "checkout" tarihinin 2023-01-20
        ve "additionalneeds“in,"wi-fi"
        oldugunu test edin

https://restful-booker.herokuapp.com/booking
     */

    @Test
    public void post11() {
        //Set the Url.
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody = new JSONObject();
        JSONObject rezervasyonTarihleri = new JSONObject();

        rezervasyonTarihleri.put("checkin", "2023-01-10");
        rezervasyonTarihleri.put("checkout", "2023-01-20");

        requestBody.put("firstname", "Recep");
        requestBody.put("lastname", "Ivedik");
        requestBody.put("totalprice", 3169);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates", rezervasyonTarihleri);
        requestBody.put("additionalneeds", "Testesteronlarim!");

        //Set the expected data.
        //Send the request and get the response.
        Response response = given().contentType(ContentType.JSON).
                when().body(requestBody.toString()).post(url);
        response.prettyPrint();

        //Do assertion.
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname", equalTo("Recep"),
                        "booking.lastname", equalTo("Ivedik"),
                        "booking.totalprice", equalTo(3169),
                        "booking.depositpaid", equalTo(false),
                        "booking.bookingdates.checkin", equalTo("2023-01-10"),
                        "booking.bookingdates.checkout", equalTo("2023-01-20"),
                        "booking.additionalneeds", equalTo("Testesteronlarim!"));
    }
}
    /*
        {
            "bookingid": 3518,
            "booking": {
                "firstname": "Recep",
                "lastname": "Ivedik",
                "totalprice": 3169,
                "depositpaid": false,
                "bookingdates": {
                    "checkin": "2023-01-10",
                    "checkout": "2023-01-20"
                },
                "additionalneeds": "Testesteronlarım!"
            }
        }

     */
