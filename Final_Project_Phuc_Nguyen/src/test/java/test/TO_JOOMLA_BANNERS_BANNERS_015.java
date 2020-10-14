package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.BannersBannersPage;
import utils.Log4j;

public class TO_JOOMLA_BANNERS_BANNERS_015 extends BaseTest {
    BannersBannersPage bannersPage = new BannersBannersPage();

    @Test(description = "User can change the quantity of items displayed in banner table")
    public void testcase015() {
        Log4j.header("TO_JOOMLA_BANNERS_BANNERS_015");
        bannersPage.selectQuantity20();
        Assert.assertTrue(bannersPage.verifyChooseQuantity20(), "Choose quantity 20 failed");
    }
}
