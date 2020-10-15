package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.BannersClientsPage;
import utils.Log4j;

import static helper.DataHelper.*;
import static utils.Constants.CLIENTS_SUCCESS_MESSAGE;

public class TC_JOOMLA_BANNERS_CLIENTS_004 extends BaseTest {
    BannersClientsPage bannersClientsPage = new BannersClientsPage();

    @Test(description = "Verify that user can unpublished a client")
    public void testcase004() {
        Log4j.header("TC_JOOMLA_BANNERS_CLIENTS_004");

        String clientTitle = randomTitle();
        String clientName = randomName();
        String clientEmail = randomEmail();

        // Verify point 1: TO_JOOMLA_BANNERS_CLIENTS_001
        bannersClientsPage.navigateToClientsPage();
        bannersClientsPage.clickNewBtn();
        bannersClientsPage.createNewClient(clientTitle, clientName, clientEmail);
        bannersClientsPage.clickSaveBtn();

        Assert.assertEquals(bannersClientsPage.getAlertMessage(), CLIENTS_SUCCESS_MESSAGE,
                "New Client Alert message failed");

        bannersClientsPage.navigateToClientManager();

        Assert.assertTrue(bannersClientsPage.isNewClientTitleDisplayed(clientTitle),
                "Create new client title failed");

        // Verify point 2: TO_JOOMLA_BANNERS_CLIENTS_004
        //TODO: Publish and un Publish

    }
}
