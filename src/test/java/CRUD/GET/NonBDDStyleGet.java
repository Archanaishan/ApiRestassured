package CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyleGet {
    //Get Request can be made in two ways.BDD (Given,when,then)and Non BDD
    public static void main(String[] args) {
        RequestSpecification r=RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/4235").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);
    }
}
