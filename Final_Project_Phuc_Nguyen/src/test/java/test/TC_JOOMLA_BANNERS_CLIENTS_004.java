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
        browserHelper.navigateToClientsPage();

        bannersClientsPage.clickNewBtn();

        bannersClientsPage.createNewClient(clientTitle, clientName, clientEmail);

        bannersClientsPage.clickSaveBtn();

        Assert.assertEquals(bannersClientsPage.getAlertMessage(), CLIENTS_SUCCESS_MESSAGE,
                "New Client Alert message failed");

        browserHelper.navigateToClientManager();

        bannersClientsPage.chooseSortByIdDescending();

        Assert.assertTrue(bannersClientsPage.isNewClientTitleDisplayed(clientTitle),
                "Create new client title failed");

        // Verify point 2: TO_JOOMLA_BANNERS_CLIENTS_004

        bannersClientsPage.selectCheckbox(clientTitle);

        bannersClientsPage.clickUnPublishBtn();

        // VP 2. A message : "1 client successfully unpublished" shows and Client is unpublished
        assertEquals(bannersClientsPage.getAlertMessage(), CLIENT_UNPUBLISHED_MESSAGE,
                "Unpublished failed ");

        assertTrue(bannersClientsPage.doesElementStatus(clientTitle,
                "unpublish"), "Element does not exist");
    }

}

