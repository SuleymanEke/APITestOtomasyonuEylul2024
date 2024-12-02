package APITestOtomasyonu.Tests;
//23. ders

import APITestOtomasyonu.TestData.TestDataJsonPlaceHolder;
import APITestOtomasyonu.baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C23_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceHolder {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda donen response’in
    status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest ediniz.
     */
    @Test
    public void C23_Get_TestDataClassKullanimi() {
        //1 - Request url ve body olustur.
        specJsonPlaceHolder.pathParams("pp1", "posts", "pp2", 22);

        //2 - Soruda varsa expected data olustur.
        JSONObject expectedData = TestDataJsonPlaceHolder.responseBodyOlustur22();
        System.out.println(expectedData);

        //3 - Response olustur, request gonderip sonucu response'i ata.
        Response response = given(specJsonPlaceHolder).when().get("{pp1}/{pp2}");
        response.prettyPrint();

        //4 - Assertion.
        JsonPath responsJsonPath = response.jsonPath();
        assertEquals(TestDataJsonPlaceHolder.basariliSorguStatucCode, response.statusCode());

        assertEquals(expectedData.getInt("userId"), responsJsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"), responsJsonPath.getInt("id"));
        assertEquals(expectedData.getString("title"), responsJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"), responsJsonPath.getString("body"));


    }
    /*
    {
    "userId": 3,
    "id": 22,
    "title": "dolor sint quo a velit explicabo quia nam",
    "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
     */

}
