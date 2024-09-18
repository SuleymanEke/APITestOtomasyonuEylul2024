package APITestOtomasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Put_ResponseBilgileriAssertion {

    /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki Json formatindaki body ile
        bir PUT request gonderdigimizde
                {
                "title": "Recep Ivedik",
                "body":"Salih Abi, bana bi' yolluk yap.",
                "userId": 31;
                "id": 69
                }
        donen Response'in, status code'unun 200,
        ve content type'inin application/json; charset=utf-8,
        ver Server isimli Header'in degerinin cloudflare,
        ve status Line'in HTTP/1.1 200 OK
         */

    @Test
    public void put06() {
        //1 - Request Body ve End-Point hazirlama.
        String url = "https://jsonplaceholder.typicode.com/posts/69";

        JSONObject requestBody = new JSONObject();

        requestBody.put("title", "Recep Ivedik");
        requestBody.put("body", "Salih Abi, bana bi' yolluk yap.");
        requestBody.put("userId", 3169);
        requestBody.put("id", 69);

        //2 - Expected Data hazirlama.
        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(requestBody.toString()).
                put(url);
        response.prettyPrint();


        //4 - Assertion.
        response.then().assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server", "cloudflare").
                statusLine("HTTP/1.1 200 OK");

    }
}
