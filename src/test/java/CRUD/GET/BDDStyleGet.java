package CRUD.GET;

import io.restassured.RestAssured;

public class BDDStyleGet {
    public static void main(String[] args) {
        //get https://api.zippopotam.us/us/90210
        //URL https://api.zippopotam.us
        //path us/90210
        //Header

        //validate

        //status code
        //Response Body
        //Time
        //Headers,Cookies

        //Rest Assured follows Gherkin syntax:Given,When,Then
        //given->URL,path,auth
        //when->Payload,method
        //then->Validation
        //Responsebody,Time,Headers,Cookies
        RestAssured.given().baseUri("https://api.zippopotam.us").basePath("IN/560037").
        when().get().then().statusCode(200);
    }
}
