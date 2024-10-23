package APITestOtomasyonu;
//17. ders.

import org.junit.Test;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {
    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
    request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.

    Response Body:
    {
            "booking": {
                "firstname": "Recep",
                "lastname": "Ivedik",
                "totalprice": 3169,
                "depositpaid": false,
                "bookingdates": {
                    "checkin": "2023-01-10",
                    "checkout": "2023-01-20"
                },
                "additionalneeds": "Lan ikiz dingiller, o dilini koparrıtım senin!"
            }

     */
    @Test
    public void C14_Post_ExpectedDataVeJsonPathIleAssertion() {
        //1 - Request Body ve End-Point hazirlama.
        //2 - Expected Data hazirlama.
        //3 - Request gonderip, donen Response'i kaydetme.
        //4 - Assertion.

    }


}
