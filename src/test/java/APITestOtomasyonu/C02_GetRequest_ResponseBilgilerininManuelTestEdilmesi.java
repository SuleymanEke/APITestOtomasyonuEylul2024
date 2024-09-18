package APITestOtomasyonu;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_ResponseBilgilerininManuelTestEdilmesi {

    /*
    https://restful-booker.herokuapp.com/booking/10 url'ine
    bir GET request gonderdigimizde donen Response'un,
    Status Code'un 200,
    ve Content Type'inin application/json; charset=utf-8,
    ve Server isimli Header'in degerinin Cowboy,
    ve Status Line'i HTTP/1.1 200 OK,
    ve Response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
    */


    @Test
    public void get02() {
        //1 - Request Body ve End-Point hazirlama.
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2 - Expected Data hazirlama.

        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given().when().get(url);
        response.prettyPrint();

        //4 - Assertion.
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Content Type: " + response.getContentType());
        System.out.println("Header: " + response.getHeader("Server"));
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Time: " + response.getTime()+" ms");
    }

}
