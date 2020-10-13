package test;

import helper.DriverHelper;
import org.testng.annotations.*;
import page.object.BasePage;
import utils.Constants;
import utils.Log4j;


public class TestHelper {

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
        Constants.DRIVER.manage().window().maximize();
        DriverHelper.navigate(Constants.RAILWAY_HOME_URL);
    }

    @AfterMethod
    public void afterMethod() {
        Log4j.info("Close browser\n");
        Constants.DRIVER.quit();
    }
}
