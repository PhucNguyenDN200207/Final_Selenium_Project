package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.BannersPage;
import utils.Log4j;

public class TO_JOOMLA_BANNERS_BANNERS_015 extends BaseTest {
    BannersPage bannersPage = new BannersPage();

    @Test(description = "User can change the quantity of items displayed in banner table")
    public void testcase015() throws InterruptedException {
        Log4j.header("TO_JOOMLA_BANNERS_BANNERS_015");
        bannersPage.selectQuantity20();
        Assert.assertTrue(bannersPage.verifyUserChoose20(), "Choose quantity 20 failed");
    }
}
