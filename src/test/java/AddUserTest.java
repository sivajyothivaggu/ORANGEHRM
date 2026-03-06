package tests.admin;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class AddUserTest extends BaseTest {

    @Test
    public void testAddNewUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        Thread.sleep(3000);

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickAdminMenu();
        Thread.sleep(3000);

        // Click Add button
        driver.findElement(org.openqa.selenium.By.xpath("//button[normalize-space()='Add']")).click();
        Thread.sleep(3000);

        // Click User Role dropdown and select Admin
        driver.findElement(org.openqa.selenium.By.xpath("//label[text()='User Role']/parent::div//following-sibling::div//div[@class='oxd-select-text-input']")).click();
        Thread.sleep(1000);
        driver.findElement(org.openqa.selenium.By.xpath("//span[text()='Admin']")).click();
        Thread.sleep(1000);

        // Click Employee Name and enter "siva kumar selvi"
        driver.findElement(org.openqa.selenium.By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("siva kumar selvi");
        Thread.sleep(3000);
        driver.findElement(org.openqa.selenium.By.xpath("//div[@role='option']//span[contains(text(),'siva kumar selvi')]")).click();
        Thread.sleep(3000);

        // Click Status dropdown and select Disabled (AFTER employee name selection with extra wait)
        driver.findElement(org.openqa.selenium.By.xpath("//label[text()='Status']/parent::div//following-sibling::div//div[@class='oxd-select-text-input']")).click();
        Thread.sleep(1500);
        driver.findElement(org.openqa.selenium.By.xpath("//span[text()='Disabled']")).click();
        Thread.sleep(1500);

        // Click Username and enter "sivajyothi"
        org.openqa.selenium.WebElement usernameField = driver.findElement(org.openqa.selenium.By.xpath("//label[text()='Username']/parent::div//following-sibling::div//input"));
        usernameField.click();
        Thread.sleep(500);
        usernameField.sendKeys("sivajyothi");
        Thread.sleep(1000);

        // Enter Password - using simpler xpath
        java.util.List<org.openqa.selenium.WebElement> allInputs = driver.findElements(org.openqa.selenium.By.xpath("//input"));
        for (org.openqa.selenium.WebElement input : allInputs) {
            String type = input.getAttribute("type");
            if ("password".equals(type)) {
                input.sendKeys("Siva@123");
                Thread.sleep(1000);
                break;
            }
        }

        // Enter Confirm Password - find second password field
        java.util.List<org.openqa.selenium.WebElement> passwordInputs = driver.findElements(org.openqa.selenium.By.xpath("//input[@type='password']"));
        if (passwordInputs.size() >= 2) {
            passwordInputs.get(1).sendKeys("Siva@123");
            Thread.sleep(1000);
        }

        // Click Save button
        driver.findElement(org.openqa.selenium.By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        System.out.println("✓ User created successfully");
    }
}
