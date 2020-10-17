package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.BannersClientsPage;
import page.object.LoginPage;
import utils.Log4j;

import static helper.DataHelper.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.Constants.*;

public class TC_JOOMLA_BANNERS_CLIENTS_004 extends BaseTest {
    BannersClientsPage bannersClientsPage = new BannersClientsPage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void login() {
        loginPage.login(USER_NAME, PASSWORD);

    }

    @Test(description = "Verify that user can unpublished a client")
    public void testcase004() {
        Log4j.header("TC_JOOMLA_BANNERS_CLIENTS_004");

        String clientTitle = randomTitle();
        String clientName = randomName();
        String clientEmail = randomEmail();

        // Verify point 1: TO_JOOMLA_BANNERS_CLIENTS_001
        Log4j.info("Step: Select Components -> Banners -> Clients");
        bannersClientsPage.clickComponentsMenu();

        bannersClientsPage.clickBannersOpt();

        bannersClientsPage.clickBannerClients();

        Log4j.info("Step: Click 'New' button in the right top corner");
        bannersClientsPage.clickNewBtn();


        Log4j.info("Step:Enter valid Client Name to Client Name textbox");
        Log4j.info("Step:Enter valid Contact Name to Contact Name textbox");
        Log4j.info("Step:Enter valid Contact Email to Contact Email textbox");
        bannersClientsPage.enterNewClient(clientTitle, clientName, clientEmail);

        Log4j.info("Step: Click 'Save & Close' button");
        bannersClientsPage.clickSaveAndCloseBtn();

        Log4j.info("Verify: A message : 'Client successfully saved' shows.");
        Assert.assertEquals(bannersClientsPage.getMessage(), CLIENTS_SUCCESS_MESSAGE,
                "New Client Alert message failed");

        bannersClientsPage.chooseSortByIdDescending();

        Log4j.info("Verify: New client is created");
        Assert.assertTrue(bannersClientsPage.isNewClientTitleDisplayed(clientTitle),
                "Create new client title failed");

        // Verify point 2: TO_JOOMLA_BANNERS_CLIENTS_004

        Log4j.info("Step: Check the Client recently created");
        bannersClientsPage.selectCheckbox(clientTitle);

        Log4j.info("Step: Click 'Unpublish' button in the right top corner");
        bannersClientsPage.clickUnPublishBtn();

        Log4j.info("Verify: A message : '1 client successfully unpublished' shows.");
        assertEquals(bannersClientsPage.getMessage(), CLIENT_UNPUBLISHED_MESSAGE,
                "Unpublished failed ");

        Log4j.info("Verify: Client is unpublished");
        assertTrue(bannersClientsPage.doesElementStatus(clientTitle,
                "unpublish"), "Element does not exist");
    }

}

