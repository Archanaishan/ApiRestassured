package CRUD.GET;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
public class NonBDDStyleTestNG {
        //Add TestNG Dependency
    //import org.testng.annotations.Test;

    @Test
    public void testGetpositive(){
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/4235").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);
    }
    @Test
    public void testGetNegative1(){
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-1").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);
    }
    @Test
    public void testGetNegative2(){
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/abc").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);
    }

}
