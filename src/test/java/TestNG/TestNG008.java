package TestNG;

import org.testng.annotations.Test;

public class TestNG008 {
    @Test
    public void serverStartedok(){
        System.out.println("I will run first");
    }
    @Test(dependsOnMethods = "serverStartedok")
    public void method(){
        System.out.println("method1");
    }
}
