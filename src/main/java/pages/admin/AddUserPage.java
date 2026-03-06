package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class AddUserPage {
    private WebDriver driver;

    @FindBy(xpath = "//label[text()='User Role']/parent::div//following-sibling::div//div[@class='oxd-select-text-input']")
    private WebElement userRoleDropdown;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameField;

    @FindBy(xpath = "//label[text()='Status']/parent::div//following-sibling::div//div[@class='oxd-select-text-input']")
    private WebElement statusDropdown;

    @FindBy(xpath = "//label[text()='Username']/parent::div//following-sibling::div//input")
    private WebElement usernameField;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement passwordField;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectUserRole(String role) {
        WaitUtils.waitForElementClickable(driver, userRoleDropdown);
        userRoleDropdown.click();
        WebElement roleOption = driver.findElement(By.xpath("//span[text()='" + role + "']"));
        roleOption.click();
    }

    public void enterEmployeeName(String name) {
        WaitUtils.waitForElementVisible(driver, employeeNameField);
        employeeNameField.sendKeys(name);
    }

    public void selectStatus(String status) {
        WaitUtils.waitForElementClickable(driver, statusDropdown);
        statusDropdown.click();
        WebElement statusOption = driver.findElement(By.xpath("//span[text()='" + status + "']"));
        statusOption.click();
    }

    public void enterUsername(String username) {
        WaitUtils.waitForElementVisible(driver, usernameField);
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WaitUtils.waitForElementVisible(driver, passwordField);
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        WaitUtils.waitForElementVisible(driver, confirmPasswordField);
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void clickSave() {
        WaitUtils.waitForElementClickable(driver, saveButton);
        saveButton.click();
    }

    public void createUser(String userRole, String employeeName, String status, String username, String password) throws InterruptedException {
        selectUserRole(userRole);
        Thread.sleep(1000);
        enterEmployeeName(employeeName);
        Thread.sleep(2000);
        selectStatus(status);
        Thread.sleep(1000);
        enterUsername(username);
        Thread.sleep(1000);
        enterPassword(password);
        Thread.sleep(1000);
        enterConfirmPassword(password);
        Thread.sleep(1000);
        clickSave();
    }
}
