package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.BannersClientsPage;
import utils.Log4j;

import static helper.DataHelper.*;
import static utils.Constants.*;

public class TC_JOOMLA_BANNERS_CLIENTS_004 extends BaseTest {
    BannersClientsPage bannersClientsPage = new BannersClientsPage();

    @Test(description = "Verify that user can unpublished a client")
    public void testcase004() {
        Log4j.header("TC_JOOMLA_BANNERS_CLIENTS_004");
        String title = randomTitle();
        String name = randomName();
        String email = randomEmail();

        bannersClientsPage.createNewClient(title, name, email);

        Assert.assertEquals(bannersClientsPage.getAlertMessage(), CLIENTS_SUCCESS_MESSAGE,
                "New Client Alert message failed");

        bannersClientsPage.navigateToClientManager();

        Assert.assertTrue(bannersClientsPage.isNewClientTitleDisplayed(title), "Create new client title failed");


    }
}
