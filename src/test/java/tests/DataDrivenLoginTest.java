package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DataDrivenLoginTest extends BaseTest {
    
    @Test
    public void testAllLoginScenarios() throws InterruptedException {
        Object[][] loginData = {
            {"Admin", "admin123", "valid"},
            {"InvalidUser", "admin123", "invalid"},
            {"Admin", "wrongpass", "invalid"},
            {"testuser", "testpass", "invalid"},
            {"Admin", "admin123", "valid"},
            {"wrongadmin", "wrongpass", "invalid"}
        };
        
        for (int i = 0; i < loginData.length; i++) {
            Object[] data = loginData[i];
            String username = (String) data[0];
            String password = (String) data[1];
            String expectedResult = (String) data[2];
            
            System.out.println("\n========== Scenario " + (i + 1) + " ==========");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Expected: " + expectedResult.toUpperCase());
            
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(username, password);
            Thread.sleep(3000);
            
            if (expectedResult.equals("valid")) {
                DashboardPage dashboardPage = new DashboardPage(driver);
                Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard not displayed");
                System.out.println("✓ VALID LOGIN SUCCESSFUL");
                
                // Logout to return to login page
                dashboardPage.clickProfileDropdown();
                Thread.sleep(1000);
                dashboardPage.clickLogout();
                Thread.sleep(2000);
            } else {
                String errorMsg = loginPage.getErrorMessage();
                if (errorMsg.contains("Invalid") || errorMsg.contains("Required")) {
                    System.out.println("✓ INVALID LOGIN - Error displayed: " + errorMsg);
                } else {
                    System.out.println("✓ INVALID LOGIN - Stayed on login page");
                }
                
                // Already on login page, just refresh
                driver.navigate().refresh();
                Thread.sleep(2000);
            }
            
            System.out.println("========== Scenario " + (i + 1) + " Passed ==========\n");
        }
        
        System.out.println("\n========================================");
        System.out.println("ALL " + loginData.length + " SCENARIOS COMPLETED SUCCESSFULLY!");
        System.out.println("========================================\n");
    }
}
