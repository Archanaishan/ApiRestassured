package CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStylePUT {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token="6c94b7bc0f4c3b5";
    @Test
    public void testPutRequest(){
        //URL-https://restful-booker.herokuapp.com
        //path-/booking/4730
        //Auth-9558d0eeea5bc61
        //Id-4730
        //Payload
        String payload="{\n" +
                "    \"firstname\" : \"Jakie\",\n" +
                "    \"lastname\" : \"Jack\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/2603");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payload);

        Response response=requestSpecification.when().put();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Jakie"));
    }
}
