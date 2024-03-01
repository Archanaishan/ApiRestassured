package TestNG;

import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Testng007 {
    //TestNG provides 2 types of assertions
    //Soft Assertions and Hard Assertions
    @Test
    void tc1() {
        SoftAssert s = new SoftAssert();
        s.assertEquals(true,false,"mismatch");
        System.out.println("Printed on faliure as it is soft assertion");
        Assert.assertEquals(true,false);
        System.out.println("Will not be printed on failure as it is hard assertion");
        s.assertAll();
    }
}
