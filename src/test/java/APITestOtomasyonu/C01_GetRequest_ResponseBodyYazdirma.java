package APITestOtomasyonu;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest_ResponseBodyYazdirma {
     /*
    https://restful-booker.herokuapp.com/booking/10 url'ine
    bir GET request gonderdigimizde donen Response'u yazdirin.
    */

    @Test
    public void get01() {
        //1 - Request Body ve End-Point hazirlama.
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2 - Expected Data hazirlama.

        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given().when().get(url);
        response.prettyPrint();

        //4 - Assertion.

        /*
            {
        "firstname": "Susan",
        "lastname": "Brown",
        "totalprice": 719,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2024-07-08",
            "checkout": "2024-08-26"
        }
    }

         */

    }
}
