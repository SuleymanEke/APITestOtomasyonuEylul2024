package APITestOtomasyonu;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Test;

public class C04_JsonObjesiOlusturma {
    @Test
        /*
      {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId": 1
        }
       */
    public void test04() {

        JSONObject obj1 = new JSONObject();

        obj1.put("title", "Recep Ivedik");
        obj1.put("body", "Bu ne saçma hayat, bu ne serkeş hayat, bu ne dingil hayat ya?");
        obj1.put("userId", 1);
        System.out.println(obj1);


    }
}
