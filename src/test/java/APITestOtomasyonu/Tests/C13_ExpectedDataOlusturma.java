package APITestOtomasyonu.Tests;
//16. ders.

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C13_ExpectedDataOlusturma {

        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda donen response
        body’sinin asagida verilen ile ayni oldugunutest ediniz:
        Response body :
        {
        "userId": 3,
        "id": 22,
        "title": "dolor sint quo a velit explicabo quia nam",
        "body": "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear
        um mollitia molestiae aut atque rem suscipitnam impedit esse"
        }
         */

    @Test
    public void C13_ExpectedDataOlusturma() {
        //1 - Request Body ve End-Point hazirlama.
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        //2 - Expected Data hazirlama.
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given().when().get(url);
        response.prettyPrint();

        //4 - Assertion.
        //1.Yol
        response.then().assertThat().body("userId", equalTo(3),
                "id", equalTo(22),
                "title", equalTo("dolor sint quo a velit explicabo quia nam"),
                "body", equalTo("eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"));

        //2.Yol
        JsonPath responseJsonPath = response.jsonPath();
        Assert.assertEquals(expectedData.get("userId"), responseJsonPath.get("userId"));
        Assert.assertEquals(expectedData.get("id"), responseJsonPath.get("id"));
        Assert.assertEquals(expectedData.get("title"), responseJsonPath.get("title"));
        Assert.assertEquals(expectedData.get("body"), responseJsonPath.get("body"));



    }

}
