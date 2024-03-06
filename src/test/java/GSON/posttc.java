package GSON;

import com.google.gson.Gson;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class posttc {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token="6c94b7bc0f4c3b5";
    @Test
    public void testpost()

    {
        //Preparing payload

        Booking payload=new Booking();
        payload.setFirstname("Jakie");
        payload.setLastname("Brown");
        payload.setTotalprice(1234);
        payload.setDepositpaid(true);
        Bookingdates bookingdates=new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");
        payload.setBookingdates(bookingdates);
        payload.setAdditionalneeds("Breakfast");
        System.out.println(payload);
        //object->Json using gson//serialization
        Gson gson=new Gson();
        String Jsonpayload=gson.toJson(payload);
        System.out.println(Jsonpayload);
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(Jsonpayload);

        Response response = requestSpecification.when().post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        //Validate Response Json to object deserialization
        String jsonResponse=response.asString();
        BookingResponse bookingresponseobject=gson.fromJson(jsonResponse, BookingResponse.class);
        //AssertJassertions
        assertThat(bookingresponseobject.getBookingid()).isNotNull();
        assertThat(bookingresponseobject.getBooking().getFirstname().equals("Jakie"));

    }
}
