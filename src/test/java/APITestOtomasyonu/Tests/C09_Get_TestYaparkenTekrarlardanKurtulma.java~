package APITestOtomasyonu;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
    /*
    C09_Get_BodyTekrarlardanKurtulma
    https://restful-booker.herokuapp.com/booking/10 url’ine
    bir GET request gonderdigimizde
    donen Response’un,
    status code’unun 200,
    ve content type’inin application-json, ve response body’sindeki
    "firstname“in, "Susan",
    ve "lastname“in, "Jackson",
    ve "totalprice“in, 612,
    ve "depositpaid“in, false,
    ve "additionalneeds“in, "Breakfast"
    oldugunu test edin.
     */

public class C09_Get_TestYaparkenTekrarlardanKurtulma {

    @Test
    public void get09() {
    //Set the Url.
     //String url ="https://restful-booker.herokuapp.com/booking/10";
     RestAssured.baseURI="https://restful-booker.herokuapp.com";
     RestAssured.basePath="/booking/10";


    //Set the expected data.
    //Send the request and get the response.
    Response response = given().when().get();
    response.prettyPrint();

    //Do assertion.
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Sally")).
                body("lastname", equalTo("Jones")).
                body("totalprice", lessThan(1000)).
                body("depositpaid", equalTo(true)).
                body("additionalneeds", equalTo("Breakfast"));
    }


}
