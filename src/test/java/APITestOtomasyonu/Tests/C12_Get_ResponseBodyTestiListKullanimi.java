package APITestOtomasyonu.Tests;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C12_Get_ResponseBodyTestiListKullanimi {

    /*
        http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
        donen Response'in;
        status code'unun 200,
        ve content type'inin Aplication.JSON,
        ve response body'sindeki
        employees sayisinin 24
        ve employee'lerden birinin "Ashton Cox"
        ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin.
     */

    @Test
    public void C12_Get_ResponseBodyTestiListKullanimi() {

        //Set the Url.
        String url = "https://dummy.restapiexample.com/api/v1/employees";

        //Set the expected data.
        //Send the request and get the response.
        Response response = given().when().get(url);
         response.prettyPrint();

        //Do assertion.
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", hasSize(24),
                        "data.employee_name", hasItem("Ashton Cox"),
                        "data.employee_age", hasItems(61, 21, 35));
    }

    /*
       {
      "id": 3,
      "employee_name": "Ashton Cox",
      "employee_salary": 86000,
      "employee_age": 66,
      "profile_image": ""
    },
     */


}
