package TestNG;

import org.testng.annotations.Test;

public class Test009 {
    @Test(groups = {"init"})
    public void serverok(){
        System.out.println("server started");
    }
    @Test(groups = {"init"})
    public void environmentok(){
        System.out.println("Environment");
    }
    @Test(dependsOnGroups =  {"init.*"})
    public void m1()
    {
        System.out.println("now method will run");
    }
}
