package TestNG;

import org.testng.annotations.*;

public class Testng002 {
    @BeforeSuite
    public void demo1(){
        //we can write code for reading data from excel,csv,JSON,Database
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void demo2(){
        //we can write code for reading data from excel,csv,JSON,Database
        System.out.println("Before Test");
    }
    @BeforeClass
    public void demo3(){
        //we can write code for reading data from excel,csv,JSON,Database
        System.out.println("Before Class");
    }
    //we can have multiple test methods.for each test method the before and after method will be run
    @BeforeMethod
    public void demo4(){
        //we can write code for reading data from excel,csv,JSON,Database
        System.out.println("Before Method");
    }
    @Test
    public void demo5(){
        System.out.println("Test");
    }
    @AfterMethod
    public void demo6(){
        //we can write code to close the files
        System.out.println("After Method");
    }
    @AfterClass
    public void demo7(){
        //we can write code for reading data from excel,csv,JSON,Database
        System.out.println("After Class");
    }
    @AfterTest
    public void demo8(){
        //we can write code for reading data from excel,csv,JSON,Database
        System.out.println("After Test");
    }
    @AfterSuite
    public void demo9(){
        //we can write code for reading data from excel,csv,JSON,Database
        System.out.println("After Suite");
    }
}
