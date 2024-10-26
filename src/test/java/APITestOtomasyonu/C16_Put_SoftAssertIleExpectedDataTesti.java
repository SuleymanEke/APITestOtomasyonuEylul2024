package APITestOtomasyonu;
//19. ders 15:02'ye geldim.

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C16_Put_SoftAssertIleExpectedDataTesti {
    /*

    http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye
    sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

    Request Body
        {
            "status": "success",
            "data": {
                "name": “Ahmet",
                "salary": "1230",
                "age": "44",
                "id": 40
            }
        }

    Response Body
        {
            "status": "success",
            "data": {
            "status": "success",
            "data": {
                    "name": “Ahmet",
                    "salary": "1230",
                    "age": "44",
                    "id": 40
            }
        },
        "message": "Successfully! Record has been updated."
    }
     */

    @Test
    public void C16_Put_SoftAssertIleExpectedDataTesti() {
        //1 - Request Body ve End-Point hazirlama.
        String url = "http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject requestBody = new JSONObject();
        JSONObject dataBilgileri = new JSONObject();

        dataBilgileri.put("name", "Recep");
        dataBilgileri.put("salary", "3169");
        dataBilgileri.put("age", "44");
        dataBilgileri.put("id", 40);

        requestBody.put("status", "success");
        requestBody.put("data", dataBilgileri);
        requestBody.put("message", "Agresifim! Kompleksliyim! Ama perdelerimi kaldirinca da kedi gibi bir insanim.");

        //2 - Expected Data hazirlama.

        JSONObject expectedData = new JSONObject();
        expectedData.put("status", "success");
        expectedData.put("data", requestBody);
        //expectedData.put("message", "Agresifim! Kompleksliyim! Ama perdelerimi kaldirinca da kedi gibi bir insanim.");
        //expectedData.put();

        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .put(url);

        response.prettyPrint();
        //4 - Assertion.


    }


}
