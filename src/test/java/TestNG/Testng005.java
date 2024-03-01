package TestNG;

import org.apache.log.Priority;
import org.testng.annotations.Test;

public class Testng005 {
    @Test(priority = 1)
    public void t1(){
        System.out.println("1");
    }
    @Test(priority = 2)
    public void t2(){
        System.out.println("2");
    }
    @Test(priority = -1)//-1 is having high priority
    public void t3(){
        System.out.println("3");
    }
}
