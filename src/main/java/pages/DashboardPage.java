package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class DashboardPage {
    
    private WebDriver driver;
    
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    private WebElement profileDropdown;
    
    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutOption;
    
    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeader;
    
    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminMenu;
    
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public boolean isDashboardDisplayed() {
        try {
            WaitUtils.waitForElementVisible(driver, dashboardHeader);
            return dashboardHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void clickProfileDropdown() {
        WaitUtils.waitForElementClickable(driver, profileDropdown);
        profileDropdown.click();
        System.out.println("Clicked profile dropdown");
    }
    
    public void clickLogout() {
        WaitUtils.waitForElementClickable(driver, logoutOption);
        logoutOption.click();
        System.out.println("Clicked Logout option");
    }
    
    public void logout() {
        clickProfileDropdown();
        clickLogout();
    }
    
    public void clickAdminMenu() {
        WaitUtils.waitForElementClickable(driver, adminMenu);
        adminMenu.click();
    }
}
