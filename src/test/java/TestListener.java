package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.CommonUtils;
import org.openqa.selenium.WebDriver;
import base.BaseTest;

public class TestListener implements ITestListener {
    
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        
        Object testClass = result.getInstance();
        if (testClass instanceof BaseTest) {
            WebDriver driver = ((BaseTest) testClass).driver;
            if (driver != null) {
                CommonUtils.takeScreenshot(driver, result.getName());
            }
        }
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }
    
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }
    
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
    }
}
