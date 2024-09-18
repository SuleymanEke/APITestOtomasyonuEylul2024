package APITestOtomasyonu;

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
        JSONArray tlfnBilgileriArr = new JSONArray();
        JSONObject cepTelJsonObj = new JSONObject();
        JSONObject evTelJsonObj = new JSONObject();

        adresJsonObj.put("streetAddress", "Sultan Sok. 15/16");
        adresJsonObj.put("city", "Istanbul");
        adresJsonObj.put("postalCode", "34865");

        cepTelJsonObj.put("type", "Iphone");
        cepTelJsonObj.put("number", "532 532 32 32");

        evTelJsonObj.put("type", "home");
        evTelJsonObj.put("number", "0216 532 25 25");

        tlfnBilgileriArr.put(cepTelJsonObj);
        tlfnBilgileriArr.put(evTelJsonObj);

        kisiBilgileriJsonObj.put("firstName", "Recep");
        kisiBilgileriJsonObj.put("lastName", "Ivedik");
        kisiBilgileriJsonObj.put("age", "31");
        kisiBilgileriJsonObj.put("address", adresJsonObj);
        kisiBilgileriJsonObj.put("phoneNumbers", tlfnBilgileriArr);

        System.out.println("First Name: " + kisiBilgileriJsonObj.get("firstName"));
        System.out.println("Last Name: " + kisiBilgileriJsonObj.get("lastName"));
        System.out.println("Age: " + kisiBilgileriJsonObj.get("age"));

        System.out.println("Street Address: " + kisiBilgileriJsonObj.getJSONObject("address").get("streetAddress"));
        System.out.println("City: " + kisiBilgileriJsonObj.getJSONObject("address").get("city"));
        System.out.println("Postal Code: " + kisiBilgileriJsonObj.getJSONObject("address").get("postalCode"));
        System.out.println("Cep Phone No: " + kisiBilgileriJsonObj.getJSONArray("phoneNumbers").
                getJSONObject(0).get("number"));
        System.out.println("Ev Phone No: " + kisiBilgileriJsonObj.getJSONArray("phoneNumbers").
                getJSONObject(1).get("number"));


    }
}
