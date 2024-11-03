package APITestOtomasyonu.Tests;

import org.junit.Test;

public class C19_BaseUrlHerokuapp {
    /*
    1- https://restful-booker.herokuapp.com/booking endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve Response’ta 12 booking oldugunu test edin.

    2- https://restful-booker.herokuapp.com/booking
        endpointine yandaki body’ye sahip bir POST request gonderdigimizde donen response’un
        status code’unun 200 oldugunu ve “firstname” degerinin “Ahmet” oldugunu test edin.

                {
                "firstname" : "Recep",
                "lastname" : “Bulut",
                "totalprice" : 500,
                "depositpaid" : false,
                "bookingdates" : {
                "checkin" : "2021-06-01",
                "checkout" : "2021-06-10"
                },
                "additionalneeds" : "wi-fi"
                }
     */



    @Test
    public void C19_BaseUrlHerokuapp(){
        //1 - Request Body ve End-Point hazirlama.
        //2 - Expected Data hazirlama.
        //3 - Request gonderip, donen Response'i kaydetme.
        //4 - Assertion.

    }

}
//21. 09.45'e geldim.


