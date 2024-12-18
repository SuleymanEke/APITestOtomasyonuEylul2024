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

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceHolder {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request
    yolladigimizda donen response’in status kodunun 200, content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive” ve response body’sinin asagida verilen ile ayni oldugunu test ediniz.
     */
    @Test
    public void C25_Put_TestDataClassKullanimi() {
        //1 - Request url ve body olustur.
        specJsonPlaceHolder.pathParams("pp1", "posts", "pp2", 70);
        JSONObject requestBody = TestDataJsonPlaceHolder.jsonBodyOlustur(10, 70, "Recep Ivedik", "Agresifim! Kompleksliyim! Ama perdelerimi kaldırınca da kedi gibi bir insanım.");

        //2 - Soruda varsa expected data olustur.
        JSONObject expectedData = TestDataJsonPlaceHolder.jsonBodyOlustur(10, 70, "Recep Ivedik", "Agresifim! Kompleksliyim! Ama perdelerimi kaldırınca da kedi gibi bir insanım.");
        System.out.println(expectedData);


        //3 - Response olustur, request gonderip sonucu response'i ata.
        Response response = given(specJsonPlaceHolder).when().body(requestBody.toString()).put("{pp1/pp2}");
        response.prettyPrint();

        //4 - Assertion.
        JsonPath responseJsonPath = response.jsonPath();
        assertEquals(expectedData.getInt("userId"), responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"), responseJsonPath.getInt("id"));
        assertEquals(expectedData.getString("title"), responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"), responseJsonPath.getString("body"));

        //status Code'unun 200 oldugunu
        assertEquals(TestDataJsonPlaceHolder.basariliSorguStatucCode, response.statusCode());

        //content type’inin “application/json; charset=utf-8” oldugunu
        assertEquals(TestDataJsonPlaceHolder.contentType, response.contentType());

        //Connection header degerinin “keep-alive” oldugunu
        assertEquals(TestDataJsonPlaceHolder.headerConnection, response.header("Connection"));


    }
    /*
        {

}
     */


}
