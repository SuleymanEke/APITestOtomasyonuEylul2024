package APITestOtomasyonu.Tests;

import APITestOtomasyonu.baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_BaseUrlDummyRestapi2 extends BaseUrlJsonPlaceHolder {

    @Test
    public void C18_delete(){

        /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request gonderdigimizde donen
        response’un status code’unun 200 oldugunu ve response body’sinin null oldugunu test edin.
         */

        //1 - Request Body ve End-Point hazirlama.
        specJsonPlaceHolder.pathParams("pp1", "posts", "pp2", 50);

        //2 - Expected Data hazirlama.
        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given().spec(specJsonPlaceHolder).when().delete("{pp1}/{pp2}");
        response.prettyPrint();

        //4 - Assertion.
        response.then().statusCode(200).body("title", Matchers.nullValue());

        //1 - Request Body ve End-Point hazirlama.
        //2 - Expected Data hazirlama.
        //3 - Request gonderip, donen Response'i kaydetme.
        //4 - Assertion.

    }

}
