package DDT;

import org.testng.annotations.Test;

public class ddt01 {
    //Data Provider:Excel file containing data
    //Apachi POI,fillo library-to read the excel file
 // 3formats of excel file before 2007-xls after 2007-xlsx.3rd form is csv=comma separated values
    @Test(dataProvider = "getData",dataProviderClass =utilexcel.class)
    public void testlogin(String Username,String Password){
        System.out.println("Username="+Username);
        System.out.println("password="+Password);
    }
}
