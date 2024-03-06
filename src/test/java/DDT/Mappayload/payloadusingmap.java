package DDT.Mappayload;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class payloadusingmap {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token="6c94b7bc0f4c3b5";
    @Test
    public void testpostRequest() {
        //Hasmap(JSON->Hashmap)
        Map<String,Object>jsonbody=new HashMap<>();
        Faker faker=new Faker();
        jsonbody.put("firstname",faker.name().firstName());
        jsonbody.put("lastname",faker.name().lastName());
        jsonbody.put("totalprice",faker.number().randomNumber());
        jsonbody.put("depositpaid",faker.random().nextBoolean());
        Map<String,Object>bookingdates=new HashMap<>();
        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");
        jsonbody.put("bookingdates",bookingdates);
        jsonbody.put("additionalneeds","Breakfast");
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        //requestSpecification.cookie("token", token);
        requestSpecification.body(jsonbody);

        Response response = requestSpecification.when().post();
        validatableResponse = response.then().log().all();
        Integer bookingid=validatableResponse.extract().path("bookingid");
        validatableResponse.statusCode(200);
        System.out.println("bookingId->"+bookingid);
    }
    }
