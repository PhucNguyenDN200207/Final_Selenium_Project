package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.BannersBannersPage;
import utils.Log4j;

public class TC_JOOMLA_BANNERS_BANNERS_015 extends BaseTest {
    BannersBannersPage bannersPage = new BannersBannersPage();

    @Test(description = "User can change the quantity of items displayed in banner table")
    public void testcase015() {
        Log4j.header("TO_JOOMLA_BANNERS_BANNERS_015");

        String quantity = "25";
        bannersPage.navigateToBannersPage();

        bannersPage.selectQuantityNumber(quantity);
        Assert.assertTrue(bannersPage.verifyChooseQuantityNumber(quantity), "Choose quantity 20 failed");
    }
}
