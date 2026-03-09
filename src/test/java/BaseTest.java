package base;

import constants.FrameworkConstants
import org.openqa.selenium.WebDriver

import utils.ConfigReader
import utils.DriverFactory
import java.time.Duration

public class BaseTest 
    
    public WebDriver driver
    
    @BeforeMethod
    public void setUp
        try {
            driver = DriverFactory.initializeDriver(ConfigReader.getBrowser());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.IMPLICIT_WAIT));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(FrameworkConstants.PAGE_LOAD_TIMEOUT));
            driver.get(ConfigReader.getUrl());
            Thread.sleep(2000);
            Systemprintln("Successfully navigated to: " + ConfigReader.getUrl());
        } catch (Exception e) {
            System.out.println("Error in setup: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
