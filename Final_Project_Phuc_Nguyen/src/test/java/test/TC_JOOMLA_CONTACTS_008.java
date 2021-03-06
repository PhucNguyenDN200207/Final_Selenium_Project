package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.ContactsPage;
import page.object.LoginPage;
import utils.Log4j;

import static utils.Constants.PASSWORD;
import static utils.Constants.USER_NAME;

public class TC_JOOMLA_CONTACTS_008 extends BaseTest {
    ContactsPage contactsPage = new ContactsPage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void login() {
        loginPage.login(USER_NAME, PASSWORD);

    }

    @Test(description = "Verify user can access contact's help section")
    public void testcase008() {
        Log4j.header("TC_JOOMLA_CONTACTS_008");

        Log4j.info("Navigate to Contact manager page");
        contactsPage.clickComponentsMenu();
        contactsPage.clickContactDrd();

        Log4j.info("Step: Click on'Help'icon of the top right toolbar");
        contactsPage.clickHelpBtn();

        Log4j.info("Verify the contact's help window is displayed");
        Assert.assertTrue(contactsPage.doesHelpWindowDisplay(), "Help page title failed");
    }
}
