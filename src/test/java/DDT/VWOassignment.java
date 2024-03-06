package DDT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class VWOassignment {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    int id;
    int Statuscode;
    String Statusmessage;
    @Test(dataProvider = "getData",dataProviderClass =utilexcel.class)
    public void login(String Username,String Password)
    {
        System.out.println(Username);
        System.out.println(Password);
        String payload="{\n" +
                "\n" +
                "  \"username\": \""+Username+"\",\n" +
                "\n" +
                "  \"password\": \""+Password+"\",\n" +
                "\n" +
                "  \"remember\": false,\n" +
                "\n" +
                "  \"recaptcha_response_field\": \"\"\n" +
                "\n" +
                "}";

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://app.vwo.com/login");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        Response response=requestSpecification.post();
        validatableResponse=response.then();
        validatableResponse.log().all();
        //id not null
        id=validatableResponse.extract().path("id");
        System.out.println(id);
        //if(id>0)
        //Statuscode 200
        //{
            Assert.assertNotNull(id);
            Assert.assertEquals(Statuscode,200);
            Statuscode=validatableResponse.extract().statusCode();
            Statusmessage=validatableResponse.extract().statusLine();
            System.out.println(Statusmessage);
            System.out.println(Statuscode);

        //}
      // else{
            Assert.assertEquals(Statuscode,401);
            Statuscode=validatableResponse.extract().statusCode();
            Statusmessage=validatableResponse.extract().statusLine();
            System.out.println(Statusmessage);
            System.out.println(Statuscode);

       // }
        //Assert.assertEquals(Statuscode,401);
    }

}
