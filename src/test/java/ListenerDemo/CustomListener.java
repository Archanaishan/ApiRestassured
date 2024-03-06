package ListenerDemo;

import org.testng.IExecutionListener;

public class CustomListener implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        //read excel file,JSON file,Allure report,reporting
        long startTime=System.currentTimeMillis();
        System.out.println("Started execution at"+startTime);
    }

    @Override
    public void onExecutionFinish() {
        long endTime=System.currentTimeMillis();
        System.out.println("Finished execution at"+endTime);
        //email time and results
    }
}
