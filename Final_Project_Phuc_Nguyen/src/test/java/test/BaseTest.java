package test;

import helper.DriverHelper;
import org.testng.annotations.*;
import utils.Log4j;

import static utils.Constants.*;


public class BaseTest {

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String browser) {
        if (browser.equals("chrome")) {
            DriverHelper.openChromeBrowser();

        } else {
            if (browser.equals("firefox")) {
                DriverHelper.openFirefoxBrowser();
            } else {
                DriverHelper.openEdgeBrowser();
            }
        }
        DRIVER.manage().window().maximize();

        Log4j.info("Navigate to JOOMLA Home Page");
        DriverHelper.navigate(JOOMLA_HOME_URL);
    }

    @AfterMethod
    public void afterMethod() {
        Log4j.info("Close browser\n");
        DRIVER.quit();
    }
}
