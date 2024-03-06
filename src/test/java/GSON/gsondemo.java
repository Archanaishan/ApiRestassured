package GSON;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class gsondemo {
    //{
        //"firstname" : "Jakie",
          //  "lastname" : "Jack",
            //"totalprice" : 111,
            //"depositpaid" : true,
           // "bookingdates" : {
       // "checkin" : "2018-01-01",
                //"checkout" : "2019-01-01"
    //},
     //   "additionalneeds" : "Breakfast"
   // }
   // RequestSpecification requestSpecification;
    //ValidatableResponse validatableResponse;
    //String token="6c94b7bc0f4c3b5";
    @Test
    public void testpost(){
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
        //requestSpecification = RestAssured.given();
        //requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        //requestSpecification.basePath("/booking");
        //requestSpecification.contentType(ContentType.JSON);
        //requestSpecification.cookie("token", token);
        //requestSpecification.body(payload);

       // Response response = requestSpecification.when().post();
        //validatableResponse = response.then().log().all();
        //Integer bookingid=validatableResponse.extract().path("bookingid");
        //validatableResponse.statusCode(200);
        //System.out.println("bookingId->"+bookingid);

    }
}
