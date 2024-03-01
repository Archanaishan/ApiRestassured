package TestNG;

import org.testng.annotations.Test;

public class Testng006 {
    @Test(groups = {"sanity","QA"})
    public void sanityrun(){
        System.out.println("Sanity");
        System.out.println("QA");
    }
    @Test(groups ={"reg","sanity","prod"})
    public void regrun()
    {
        System.out.println("reg");

    }
    @Test(groups ={"smoke","sanity","prod"})
    public void smokerun(){
        System.out.println("Smoke");
            }
}
