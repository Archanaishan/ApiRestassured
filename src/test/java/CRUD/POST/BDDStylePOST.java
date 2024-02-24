package CRUD.POST;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.net.URL;

public class BDDStylePOST {

    @Test
    public void testBDDStylePOSTpositive()
    {
        //URL
        //Header content type
        //Payload
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        RestAssured.
                given().
                baseUri("https://restful-booker.herokuapp.com").
                basePath("/auth").
                contentType(ContentType.JSON).body(payload).
                when().post().
                then().log().all().statusCode(200);
    }
}
