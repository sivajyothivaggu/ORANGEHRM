package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class LoginPage {
    
    private WebDriver driver;
    
    @FindBy(name = "username")
    private WebElement usernameField;
    
    @FindBy(name = "password")
    private WebElement passwordField;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    
    @FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
    private WebElement errorMessage;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public boolean isLoginPageDisplayed() {
        WaitUtils.waitForElementVisible(driver, usernameField);
        return usernameField.isDisplayed();
    }
    
    public void enterUsername(String username) {
        WaitUtils.waitForElementVisible(driver, usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        System.out.println("Entered username: " + username);
    }
    
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Entered password: " + password);
    }
    
    public void clickLogin() {
        WaitUtils.waitForElementClickable(driver, loginButton);
        loginButton.click();
        System.out.println("Clicked Login button");
    }
    
    public String getErrorMessage() {
        try {
            WaitUtils.waitForElementVisible(driver, errorMessage);
            return errorMessage.getText();
        } catch (Exception e) {
            return "No error message found";
        }
    }
    
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
