package APITestOtomasyonu.Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

    /*
    https://jsonplaceholder.typicode.com/posts/44 url'ine ir GET request yolladigimizda
    donen Response'in,
        status code'unun 200,
            ve content type'inin Application.JSON,
            ve response body'sinde bulunan userId'sinin 5,
        ve response body'sinde bulunan title'in "optio dolor molestias sit"
    oldugunu test edin.
     */

public class C07_Get_ResponseBodyTesti {
    @Test
    public void get07() {
        //1 - Request Body ve End-Point hazirlama.
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        //2 - Expected Data hazirlama.
        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given().when().get(url);

        //4 - Assertion.
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("userId", Matchers.equalTo(5)).
                body("title", Matchers.equalTo("optio dolor molestias sit"));

    }
}
