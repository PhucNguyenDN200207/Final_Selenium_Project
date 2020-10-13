package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.ContactsPage;
import utils.Constants;

import static utils.Constants.ARTICLE_ALERT_MESSAGE;
import static utils.Constants.CONTACT_SUCCESS_MESSAGE;

public class TC_JOOMLA_CONTACTS_001 extends TestHelper {
    ContactsPage contactsPage = new ContactsPage();

    @BeforeMethod
    public void preCondition() {
        contactsPage.login();
    }

    @Test(description = "User can create new contact with valid information")
    public void testcase001() {
        contactsPage.createNewContact();
        Assert.assertEquals(contactsPage.getAlertMessage(),
                CONTACT_SUCCESS_MESSAGE, "Alert message failed");
    }
}
