package TestNG;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Testng001 {
    @Test
    public void testcase1(){
        Assert.assertEquals(true,true);
    }
    @Test
    public void testcase2(){
        Assert.assertEquals(false,true);
    }
}
