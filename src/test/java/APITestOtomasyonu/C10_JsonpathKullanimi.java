package APITestOtomasyonu;
//14. ders

import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonpathKullanimi {
    @Test
    public void JsonPathTest10() {

        JSONObject kisiBilgileriJsonObj = new JSONObject();
        JSONObject adresJsonObj = new JSONObject();
        JSONArray telefonBilgileriArr = new JSONArray();
        JSONObject cepTelJsonObj = new JSONObject();
        JSONObject evTelJsonObj = new JSONObject();

        adresJsonObj.put("streetAddress", "Sultan Sok.");
        adresJsonObj.put("city", "Istanbul");
        adresJsonObj.put("postalCode", "34862");

        cepTelJsonObj.put("type", "Iphone");
        cepTelJsonObj.put("number", "0532 232 3232");
        evTelJsonObj.put("type", "Home");
        evTelJsonObj.put("number", "0216 232 3232");

        telefonBilgileriArr.put(cepTelJsonObj);
        telefonBilgileriArr.put(evTelJsonObj);

        kisiBilgileriJsonObj.put("firstName", "Recep");
        kisiBilgileriJsonObj.put("lastName", "Ivedik");
        kisiBilgileriJsonObj.put("age", 35);
        kisiBilgileriJsonObj.put("address", adresJsonObj);
        kisiBilgileriJsonObj.put("phoneNumbers", telefonBilgileriArr);

        System.out.println(kisiBilgileriJsonObj);

        System.out.println("First Name: " + kisiBilgileriJsonObj.get("firstName"));
        System.out.println("Last Name: " + kisiBilgileriJsonObj.get("lastName"));
        System.out.println("Age: " + kisiBilgileriJsonObj.get("age"));
        System.out.println("Street Names : " + kisiBilgileriJsonObj.getJSONObject("address").get("streetAddress"));
        System.out.println("City Name: " + kisiBilgileriJsonObj.getJSONObject("address").get("city"));
        System.out.println("Postal Code: " + kisiBilgileriJsonObj.getJSONObject("address").get("postalCode"));

        System.out.println("Phone Type: " + kisiBilgileriJsonObj.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));
        System.out.println("Phone Number: " + kisiBilgileriJsonObj.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        System.out.println("Phone Type: " + kisiBilgileriJsonObj.getJSONArray("phoneNumbers").getJSONObject(1).get("type"));
        System.out.println("Phone Number: " + kisiBilgileriJsonObj.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));

    }
}

/*
 {
    "firstname": "Recep",
    "adress": {
      "streetAddress": "Sultan Sok.",
      "city": "Istanbul",
      "postalCode": "34862"
    },
    "age": 35,
    "phoneNumbers": [
      {
        "numer": "0532 232 3232",
        "type": "Iphone"
      },
      {
        "numer": "0216 232 3232",
        "type": "home"
      }
    ],
    "lastname": "Ivedik"
  }

 */