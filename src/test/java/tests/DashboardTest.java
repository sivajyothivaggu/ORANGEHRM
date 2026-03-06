package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class DashboardTest extends BaseTest {
    
    @Test
    public void testDashboardAccess() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        
        loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());
        Thread.sleep(3000);
        
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard not accessible");
        System.out.println("✓ Dashboard access test passed");
    }
}
