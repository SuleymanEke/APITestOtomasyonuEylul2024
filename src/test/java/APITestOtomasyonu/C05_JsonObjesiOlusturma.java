package APITestOtomasyonu;

import org.json.JSONObject;
import org.junit.Test;

public class C05_JsonObjesiOlusturma {

    @Test
    public void test05() {
        /*
      {
        "firstname": "Recep",
        "additonalneeds":"Nedir senin derdin arkadaşım?",
        "bookingdates":{
            "checkin":"2018-01-01",
            "checkout":"2019-01-01"
        },
        "totalprice":3169,
        "depositpaid":true,
        'lastname":"Ivedik"
        }
         */

        //Once inner Json objesini olusturalim
        JSONObject dateJsonObject = new JSONObject();

        dateJsonObject.put("checkin", "2018-01-01");
        dateJsonObject.put("checkout", "2019-01-01");

        //Sonra outer Json objesini olusturup, yeri geldiginde inner objeyi koyalim.

        JSONObject requestBody = new JSONObject();

        requestBody.put("firstname", "Recep");
        requestBody.put("additonalneeds", "Nedir senin derdin arkadaşım?");
        requestBody.put("bookingdates", dateJsonObject);
        requestBody.put("totalprice", 3169);
        requestBody.put("depositpaid", true);
        requestBody.put("lastname", "Ivedik");

        System.out.println(requestBody);

        //{"firstname":"Recep",
        // "additonalneeds":"Nedir senin derdin arkadaşım?",
        // "bookingdates":{"checkin":"2018-01-01",
        // "checkout":"2019-01-01"},
        // "totalprice":3169,
        // "depositpaid":true,
        // "lastname":"Ivedik"}

    }
}
