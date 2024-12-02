package APITestOtomasyonu.Tests;

import APITestOtomasyonu.TestData.TestDataJsonPlaceHolder;
import APITestOtomasyonu.baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceHolder {
    /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
        yolladigimizda donen response’in status kodunun 200 ve response body’sinin asagida
        verilen ile ayni oldugunutest ediniz.

            Response body :
            {
            "userId": 4,
            "id": 40,
            "title": "enim quo cumque",
            "body": "ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia
            quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
            }
     */

    @Test
    public void C24_Get_TestDataClassKullanimi() {

        //1 - Request url ve body olustur.
        specJsonPlaceHolder.pathParams("pp1", "posts", "pp2", 22);

        //2 - Soruda varsa expected data olustur.
        JSONObject expectedData = TestDataJsonPlaceHolder.jsonBodyOlustur(3, 22, "dolor sint quo a velit explicabo quia nam", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");
        System.out.println(expectedData);

        //3 - Response olustur, request gonderip sonucu response'i ata.
        Response response = given(specJsonPlaceHolder).when().get("{pp1}/{pp2}");
        response.prettyPrint();

        //4 - Assertion.
        JsonPath responseJsonPath = response.jsonPath();
        assertEquals(TestDataJsonPlaceHolder.basariliSorguStatucCode, response.statusCode());

        assertEquals(expectedData.getInt("userId"), responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"), responseJsonPath.getInt("id"));
        assertEquals(expectedData.getString("title"), responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"), responseJsonPath.getString("body"));

            /*
    {
    "userId": 3,
    "id": 22,
    "title": "dolor sint quo a velit explicabo quia nam",
    "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
     */


    }
}
