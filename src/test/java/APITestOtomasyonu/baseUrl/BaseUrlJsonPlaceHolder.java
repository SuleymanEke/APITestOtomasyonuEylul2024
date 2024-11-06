package APITestOtomasyonu.baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlJsonPlaceHolder {
    protected RequestSpecification specJsonPlaceHolder;

    @Before
    public void setUp() {
        specJsonPlaceHolder = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .setContentType(ContentType.JSON)
                .build();
    }

}
