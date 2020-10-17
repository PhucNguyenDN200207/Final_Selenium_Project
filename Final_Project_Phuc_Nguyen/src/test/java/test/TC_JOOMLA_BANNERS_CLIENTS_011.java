package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.BannersClientsPage;
import page.object.LoginPage;
import utils.Log4j;

import static helper.DataHelper.*;
import static utils.Constants.*;

public class TC_JOOMLA_BANNERS_CLIENTS_011 extends BaseTest {
    BannersClientsPage bannersClientsPage = new BannersClientsPage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void login() {
        loginPage.login(USER_NAME, PASSWORD);

    }

    @Test(description = "Verify that user can create many clients by using 'Save & New' button")
    public void testcase011() {
        Log4j.header("TC_JOOMLA_BANNERS_CLIENTS_011");

        String client1Title = randomTitle();
        String client1Name = randomName();
        String client1Email = randomEmail();

        // Verify point 1: TO_JOOMLA_BANNERS_CLIENTS_001
        Log4j.info("Step: Select Components -> Banners -> Clients");
        bannersClientsPage.clickComponentsMenu();

        bannersClientsPage.clickBannersOpt();

        bannersClientsPage.clickBannerClients();

        Log4j.info("Step: Click 'New' button in the right top corner");
        bannersClientsPage.clickNewBtn();


        Log4j.info("Step:Enter valid Client Name 1 to Client Name textbox");
        Log4j.info("Step:Enter valid Contact Name 1 to Contact Name textbox");
        Log4j.info("Step:Enter valid Contact Email 1 to Contact Email textbox");
        bannersClientsPage.enterNewClient(client1Title, client1Name, client1Email);

        Log4j.info("Step: Click 'Save & Close' button");
        bannersClientsPage.clickSaveNewBtn();

        Log4j.info("Verify: A message : 'Client successfully saved' shows.");
        Assert.assertEquals(bannersClientsPage.getMessage(), CLIENTS_SUCCESS_MESSAGE,
                "New Client Alert message failed");

        // Verify point 2: TO_JOOMLA_BANNERS_CLIENTS_011

        String client2Title = randomTitle();
        String client2Name = randomName();
        String client2Email = randomEmail();

        Log4j.info("Step:Enter valid Client Name 2 to Client Name textbox");
        Log4j.info("Step:Enter valid Contact Name 2 to Contact Name textbox");
        Log4j.info("Step:Enter valid Contact Email 2 to Contact Email textbox");
        bannersClientsPage.enterNewClient(client1Title, client1Name, client1Email);
        bannersClientsPage.enterNewClient(client2Title, client2Name, client2Email);

        bannersClientsPage.clickSaveAndCloseBtn();

        Log4j.info("Verify: A message : 'Client successfully saved' shows.");
        Assert.assertEquals(bannersClientsPage.getMessage(), CLIENTS_SUCCESS_MESSAGE,
                "New Client Alert message failed");

        bannersClientsPage.chooseSortByIdDescending();

        Log4j.info("Verify: Two new clients are created");
        Assert.assertTrue(bannersClientsPage.isNewClientTitleDisplayed(client1Title),
                "Create new client 1 title failed");

        Assert.assertTrue(bannersClientsPage.isNewClientTitleDisplayed(client2Title),
                "Create new client 2 title failed");
    }
}
