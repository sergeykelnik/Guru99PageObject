package testClasses.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer
{

    private static int maxTry = 0; //Run the failed test 2 times //changed to 0
    private int count = 0;

    @Override
    public boolean retry(ITestResult iTestResult)
    {
        if (!iTestResult.isSuccess())
        {                      //Check if test not succeed
            if (count < maxTry)
            {                            //Check if maxtry count is reached
                count++;                                     //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed and take base64Screenshot
                return true;                                 //Tells TestNG to re-run the test
            }
        } else
        {
            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
    }
}
