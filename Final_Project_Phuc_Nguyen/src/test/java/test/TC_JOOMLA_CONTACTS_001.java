package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.ContactsPage;
import utils.Log4j;

import static utils.Constants.*;

public class TC_JOOMLA_CONTACTS_001 extends TestHelper {
    ContactsPage contactsPage = new ContactsPage();

    @BeforeMethod
    public void preCondition() {
        contactsPage.login();
    }

    @Test(description = "User can create new contact with valid information")
    public void testcase001() {
        Log4j.header("TC_JOOMLA_CONTACTS_001");

        contactsPage.createNewContact();
        Assert.assertEquals(contactsPage.getAlertMessage(),
                CONTACT_SUCCESS_MESSAGE, "Alert message failed");
    }
}
