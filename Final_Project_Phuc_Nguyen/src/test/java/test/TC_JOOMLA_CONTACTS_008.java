package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.ContactsPage;
import utils.Log4j;

public class TC_JOOMLA_CONTACTS_008 extends BaseTest {
    ContactsPage contactsPage = new ContactsPage();

    @Test(description = "Verify user can access contact's help section")
    public void testcase008() throws InterruptedException {
        Log4j.header("TC_JOOMLA_CONTACTS_008");

        Log4j.info("Navigate to Article manager page");
        contactsPage.clickComponentsMenu();
        contactsPage.clickContactDrd();
        contactsPage.openHelpPage();

        Assert.assertTrue(contactsPage.doesHelpWindowDisplay(), "Help page title failed");
    }
}