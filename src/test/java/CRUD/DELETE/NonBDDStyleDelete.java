package CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStyleDelete {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token="71df605f1009d53";
    @Test
    public void testPutRequest(){
        //URL-https://restful-booker.herokuapp.com
        //path-/booking/4730
        //Auth-9558d0eeea5bc61
        //Id-4730
        //Payload

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/2462");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        //requestSpecification.body(payload);

        Response response=requestSpecification.when().patch();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
       // validatableResponse.body("firstname", Matchers.equalTo("Jakie"));
    }
}
