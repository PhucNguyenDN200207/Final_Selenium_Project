package test;

import helper.BrowserHelper;
import org.testng.annotations.*;
import page.object.LoginPage;
import utils.Log4j;

import static utils.Constants.*;


public class BaseTest {
    LoginPage loginPage = new LoginPage();
    BrowserHelper browserHelper = new BrowserHelper();

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String browser) {
        if (browser.equals("chrome")) {
            BrowserHelper.openChromeBrowser();

        } else {
            if (browser.equals("firefox")) {
                BrowserHelper.openFirefoxBrowser();
            } else {
                BrowserHelper.openEdgeBrowser();
            }
        }
        DRIVER.manage().window().maximize();

        Log4j.info("Navigate to JOOMLA Home Page");
        BrowserHelper.navigate(JOOMLA_HOME_URL);

        loginPage.login();
    }

    @AfterMethod
    public void afterMethod() {
        Log4j.info("Close browser\n");
        DRIVER.quit();
    }
}
