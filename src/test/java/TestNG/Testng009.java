package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testng009 {
    //Data Driven testing
    //Testing for multiple inputs
    //for example login test for 100 users
   @DataProvider
   public Object[][] getdata(){
return new Object[][]{
        new Object[]{"admin","admin"},
        new Object[]{"admin","pwd"},
        new Object[]{"admin","password"},
};
   }
   @Test(dataProvider = "getdata")
    public void login(String Username,String password){
       System.out.println(Username);
       System.out.println(password);
   }
}
