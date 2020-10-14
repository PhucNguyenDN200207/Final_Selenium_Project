package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.BannersBannersPage;
import page.object.BannersClientsPage;
import utils.Log4j;

import static helper.DataHelper.*;
import static utils.Constants.CLIENTS_SUCCESS_MESSAGE;

public class TC_JOOMLA_BANNERS_BANNERS_001 extends BaseTest {
    BannersBannersPage bannersPage = new BannersBannersPage();
    BannersClientsPage bannersClientsPage = new BannersClientsPage();

    @Test(description = "User can create new banner with valid information")
    public void testcase001() {
        Log4j.header("TC_JOOMLA_BANNERS_BANNERS_001");

        String title = randomTitle();
        String name = randomName();
        String email = randomEmail();

        bannersClientsPage.createNewClient(title, name, email);

        Assert.assertEquals(bannersClientsPage.getAlertMessage(),
                CLIENTS_SUCCESS_MESSAGE, "Banners Alert message failed");

        //  Assert.assertTrue(bannersClientsPage.verifyCreateNewClientSuccess());
        //TODO: Not finished yet
    }
}
