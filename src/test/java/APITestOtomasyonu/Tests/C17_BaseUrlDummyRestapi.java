package APITestOtomasyonu.Tests;

import APITestOtomasyonu.baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlDummyRestapi extends BaseUrlJsonPlaceHolder {

    @Test
    public void C17_get01() {
        /*
        1-	https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde donen response’un
        status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test edin
         */

        //1 - Request Body ve End-Point hazirlama.
        specJsonPlaceHolderApi.pathParam("pp1", "posts");

        //2 - Expected Data hazirlama.
        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given(specJsonPlaceHolderApi).when().get("{pp1}");
        response.prettyPrint();

        //4 - Assertion.
        response.then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.hasSize(100));
    }

    @Test
    public void C17_get02() {
        /*
        2-	https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde donen
        response’un         status code’unun 200 oldugunu ve “title” degerinin “optio dolor molestias sit”
        oldugunu test edin.
         */
        //1 - Request Body ve End-Point hazirlama.
        specJsonPlaceHolderApi.pathParams("pp1", "posts", "pp2", 44);

        //2 - Expected Data hazirlama.
        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given().spec(specJsonPlaceHolderApi).when().get("{pp1}/{pp2}");
        response.prettyPrint();

        //4 - Assertion.
        response.then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.equalTo("optio dolor molestias sit"));
    }

    @Test
    public void C17_get03() {
        /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request gonderdigimizde donen
        response’un status code’unun 200 oldugunu ve response body’sinin null oldugunu test edin.
         */

        //1 - Request Body ve End-Point hazirlama.
        specJsonPlaceHolderApi.pathParams("pp1", "posts", "pp2", 50);

        //2 - Expected Data hazirlama.
        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given().spec(specJsonPlaceHolderApi).when().delete("{pp1}/{pp2}");
        response.prettyPrint();

        //4 - Assertion.
        response.then().statusCode(200).body("title", Matchers.nullValue());

    }

}