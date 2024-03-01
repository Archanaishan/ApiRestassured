package TestNG;
import static org.assertj.core.api.Assertions.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG003 {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token;
    @BeforeTest
    public void getToken(){
        requestSpecification= RestAssured.given();
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        Response response=requestSpecification.post();
        validatableResponse=response.then();
        validatableResponse.log().all();
        //RestAssured->Matchers(Hamcrest)->1 to 2%of time
        validatableResponse.body("token", Matchers.notNullValue());
        //TestNG Assertion
        token=response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);
        //AssertJ library
        assertThat(token).isNotNull().isNotBlank().isNotEmpty();
        System.out.println(token);
    }

    @Test
    public void NonBDDStylePut(){
        String JSONString="{\n" +
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
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/2265");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(JSONString);

        Response response=requestSpecification.when().put();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Jakie"));

    }
}
