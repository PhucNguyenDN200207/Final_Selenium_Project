package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.BannersBannersPage;
import page.object.LoginPage;
import utils.Log4j;

import static utils.Constants.PASSWORD;
import static utils.Constants.USER_NAME;

public class TC_JOOMLA_BANNERS_BANNERS_015 extends BaseTest {
    BannersBannersPage bannersPage = new BannersBannersPage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void login() {
        loginPage.login(USER_NAME, PASSWORD);

    }

    @Test(description = "User can change the quantity of items displayed in banner table")
    public void testcase015() {
        Log4j.header("TO_JOOMLA_BANNERS_BANNERS_015");

        int quantity = 20;

        Log4j.info("Step: Select Components -> Banners");
        bannersPage.clickComponentsMenu();

        bannersPage.clickBannersOpt();

        Log4j.info("Step: Select quantity that user wants to display:" + quantity);
        bannersPage.selectQuantityOption(quantity);

        Log4j.info("Verify: Quantity of items displayed in table is changed");
        Assert.assertEquals(bannersPage.getChooseQuantityOption(), quantity, "Choose quantity failed");
    }
}
