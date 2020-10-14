package test;

import org.testng.annotations.Test;
import page.object.BannersBannersPage;
import page.object.BannersClientsPage;
import page.object.BasePage;
import utils.Log4j;

public class TC_JOOMLA_BANNERS_CLIENTS_004 extends BasePage {
    BannersClientsPage bannersClientsPage = new BannersClientsPage();

    @Test(description = "Verify that user can unpublished a client")
    public void testcase004() {
        Log4j.header("TC_JOOMLA_BANNERS_CLIENTS_004");

        //TODO: not finished
    }
}
