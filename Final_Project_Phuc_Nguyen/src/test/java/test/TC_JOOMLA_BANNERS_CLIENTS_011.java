package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.BannersClientsPage;
import utils.Log4j;

import static helper.DataHelper.*;
import static utils.Constants.CLIENTS_SUCCESS_MESSAGE;

public class TC_JOOMLA_BANNERS_CLIENTS_011 extends BaseTest {
    BannersClientsPage bannersClientsPage = new BannersClientsPage();

    @Test(description = "Verify that user can create many clients by using 'Save & New' button")
    public void testcase004() {
        Log4j.header("TC_JOOMLA_BANNERS_CLIENTS_011");

        String client1Title = randomTitle();
        String client1Name = randomName();
        String client1Email = randomEmail();

        // Verify point 1: TO_JOOMLA_BANNERS_CLIENTS_001
        bannersClientsPage.navigateToClientsPage();
        bannersClientsPage.clickNewBtn();
        bannersClientsPage.createNewClient(client1Title, client1Name, client1Email);
        bannersClientsPage.clickSaveNewBtn();

//        Assert.assertEquals(bannersClientsPage.getAlertMessage(), CLIENTS_SUCCESS_MESSAGE,
//                "New Client 1 Alert message failed");


        // Verify point 2: TO_JOOMLA_BANNERS_CLIENTS_011

        String client2Title = randomTitle();
        String client2Name = randomName();
        String client2Email = randomEmail();

        // Verify point 1: TO_JOOMLA_BANNERS_CLIENTS_001
        bannersClientsPage.createNewClient(client2Title, client2Name, client2Email);
        bannersClientsPage.clickSaveBtn();

//        Assert.assertEquals(bannersClientsPage.getAlertMessage(), CLIENTS_SUCCESS_MESSAGE,
//                "New Client 2 Alert message failed");

        bannersClientsPage.navigateToClientManager();

        Assert.assertTrue(bannersClientsPage.isNewClientTitleDisplayed(client1Title),
                "Create new client 1 title failed");
        Assert.assertTrue(bannersClientsPage.isNewClientTitleDisplayed(client2Title),
                "Create new client 2 title failed");

        //TODO fix error
    }
}
