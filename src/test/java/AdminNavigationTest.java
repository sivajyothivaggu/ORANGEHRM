package tests.admin;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.admin.AddUserPage;

public class AdminNavigationTest extends BaseTest {

    @Test
    public void testAdminAddUserNavigation() throws InterruptedException {
        System.out.println("\n========== Admin Navigation Test Started ==========");
        
        // Step 1-4: Login
        System.out.println("Step 1-4: Logging in...");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        Thread.sleep(3000);
        
        // Step 5-6: Validate Dashboard
        System.out.println("Step 5-6: Validating Dashboard...");
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard heading not visible");
        System.out.println("✓ Dashboard heading visible");
        System.out.println("✓ Login successful");
        
        // Step 7: Click Admin menu
        System.out.println("Step 7: Clicking Admin menu...");
        dashboardPage.clickAdminMenu();
        Thread.sleep(3000);
        
        // Step 8-9: Validate System Users page
        System.out.println("Step 8-9: Validating System Users page...");
        Thread.sleep(2000);
        boolean systemUsersHeading = driver.findElement(org.openqa.selenium.By.xpath("//h5[text()='System Users'] | //h6[text()='System Users'] | //span[contains(text(),'System Users')]")).isDisplayed();
        Assert.assertTrue(systemUsersHeading, "System Users heading not visible");
        System.out.println("✓ System Users heading visible");
        
        boolean searchSection = driver.findElement(org.openqa.selenium.By.xpath("//button[normalize-space()='Search']")).isDisplayed();
        Assert.assertTrue(searchSection, "Search section not visible");
        System.out.println("✓ Search section visible");
        
        // Step 10: Click Add button
        System.out.println("Step 10: Clicking Add button...");
        driver.findElement(org.openqa.selenium.By.xpath("//button[normalize-space()='Add']")).click();
        Thread.sleep(3000);
        
        // Step 11-12: Validate Add User page
        System.out.println("Step 11-12: Validating Add User page...");
        boolean addUserHeading = driver.findElement(org.openqa.selenium.By.xpath("//h6[text()='Add User']")).isDisplayed();
        Assert.assertTrue(addUserHeading, "Add User heading not visible");
        System.out.println("✓ Add User heading visible");
        
        boolean userRoleField = driver.findElement(org.openqa.selenium.By.xpath("//label[text()='User Role']")).isDisplayed();
        Assert.assertTrue(userRoleField, "User Role field not visible");
        System.out.println("✓ Required fields visible");
        
        // Step 13: Click Save button without entering data
        System.out.println("Step 13: Clicking Save button without data...");
        org.openqa.selenium.WebElement saveButton = driver.findElement(org.openqa.selenium.By.xpath("//button[@type='submit']"));
        Assert.assertTrue(saveButton.isEnabled(), "Save button not clickable");
        System.out.println("✓ Save button clickable");
        
        saveButton.click();
        Thread.sleep(2000);
        
        // Validate required field messages appear
        System.out.println("Validating required field messages...");
        java.util.List<org.openqa.selenium.WebElement> requiredMessages = driver.findElements(org.openqa.selenium.By.xpath("//span[text()='Required']"));
        Assert.assertTrue(requiredMessages.size() > 0, "Required field validation messages not displayed");
        System.out.println("✓ Required field validation messages appear (Expected behavior)");
        System.out.println("✓ Total validation messages: " + requiredMessages.size());
        
        System.out.println("\n========== Test Result: PASSED ==========");
        System.out.println("✓ User successfully logged in");
        System.out.println("✓ Admin page opened successfully");
        System.out.println("✓ Add User page opened successfully");
        System.out.println("✓ Save button worked and showed validation messages");
        System.out.println("========================================\n");
    }
}
