package APITestOtomasyonu.TestData;

import netscape.javascript.JSObject;
import org.json.JSONObject;

public class TestDataJsonPlaceHolder {
    public static int basariliSorguStatucCode = 200;
    public static int basarisizSorguStatucCode = 404;
    public static String contentType = "application/json; charset=utf-8";
    public static String headerConnection = "keep-alive";

    public static JSONObject responseBodyOlustur22() {
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expectedData;
    }

    public static JSONObject jsonBodyOlustur(int userId, int id, String title, String body) {
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId", userId);
        expectedData.put("id", id);
        expectedData.put("title", title);
        expectedData.put("body", body);

        return expectedData;

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
