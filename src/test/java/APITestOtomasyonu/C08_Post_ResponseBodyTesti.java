package APITestOtomasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_Post_ResponseBodyTesti {
    /*
    https://jsonplaceholder.typicode.com/posts  url’ine asagidaki body ile
    bir POST request gonderdigimizde
    {
    "title":"Recep Ivedik",
    "body":"Agresifim! Kompleksliyim! Ama perdelerimi kaldırınca da kedi gibi bir insanım.",
    "userId":3169,
    }
    donen Response’un,
    status code’unun 201,
    ve content type’inin application/json
    ve Response Body'sindeki
    ve "title"in "API" oldugunu
    ve "userId" degerinin 100'den kucuk oldugunu "body" nin "API" kelimesi icerdigini
    test edin.

    ORNEK: body("body",Matchers.containsString("API")).body("userId",Matchers.lessThan(100));
     */

    @Test
    public void post08() {
        //1 - Request Body ve End-Point hazirlama.
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Recep Ivedik");
        requestBody.put("body", "Agresifim! Kompleksliyim! Ama perdelerimi kaldırınca da kedi gibi bir insanım.");
        requestBody.put("userId", 69);

        //2 - Expected Data hazirlama.
        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(requestBody.toString()).
                post(url);
        response.prettyPrint();

        //4 - Assertion.
        response.
                then().
                assertThat().
                statusCode(201).
                contentType(ContentType.JSON).
                body("title", Matchers.equalTo("Recep Ivedik")).
                body("userId", Matchers.lessThan(100)).
                body("title", Matchers.containsString("Recep Ivedik"));

    }

}
