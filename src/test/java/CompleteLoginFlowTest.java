package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class CompleteLoginFlowTest extends BaseTest 
    
    @Test
    public void testCompleteLoginLogoutFlow() throws InterruptedException 
        System.out.println("\n========== Starting Complete Login-Logout Flow ==========");
        
        // Step 1: Login with valid credentials
        System.out.println("\nStep 1: Logging in with valid credentials...")
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword())
        Thread.sleep(3000);
        System.out.println("✓ Logged in successfully");
        
        // Step 2: Verify navigation to dashboard
        System.out.println("\nStep 2: Verifying dashboard...");
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard not displayed");
        System.out.println("✓ Dashboard displayed");
        
        // Step 3: Click on profile
        System.out.println("\nStep 3: Clicking on profile...");
        dashboardPage.clickProfileDropdown();
        System.out.println("✓ Profile dropdown opened");
        
        // Step 4: Wait 5 seconds
        System.out.println("\nStep 4: Waiting 5 seconds...");
        Thread.sleep(5000);
        System.out.println("✓ Wait completed");
        
        // Step 5: Click logout
        System.out.println("\nStep 5: Clicking logout...");
        dashboardPage.clickLogout();
        Thread.sleep(2000);
        System.out.println("✓ Logout clicked");
        
        // Step 6: Verify navigation to login page
        System.out.println("\nStep 6: Verifying navigation to login page...");
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Not redirected to login page");
        System.out.println("✓ Navigated back to login page");
        
        System.out.println("\n========== Complete Login-Logout Flow PASSED ==========\n");
    }
}
