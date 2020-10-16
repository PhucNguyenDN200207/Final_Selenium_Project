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

        String quantity = "25";
        bannersPage.clickComponentsMenu();

        bannersPage.clickBannersDrd();

        bannersPage.selectQuantityNumber(quantity);

        Assert.assertTrue(bannersPage.verifyChooseQuantityNumber(quantity), "Choose quantity 20 failed");
    }
}
