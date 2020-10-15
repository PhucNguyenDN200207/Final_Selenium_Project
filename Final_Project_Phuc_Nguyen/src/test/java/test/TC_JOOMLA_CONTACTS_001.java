package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.ContactsPage;
import utils.Log4j;

import static helper.DataHelper.randomName;
import static utils.Constants.CONTACT_SUCCESS_MESSAGE;

public class TC_JOOMLA_CONTACTS_001 extends BaseTest {
    ContactsPage contactsPage = new ContactsPage();

    @Test(description = "User can create new contact with valid information")
    public void testcase001() {
        Log4j.header("TC_JOOMLA_CONTACTS_001");
        String name = randomName();

        contactsPage.createNewContact(name);

        Assert.assertEquals(contactsPage.getAlertMessage(),
                CONTACT_SUCCESS_MESSAGE, "Contact Alert message failed");

        browserHelper.navigateToContactManagerPage();

        Assert.assertTrue(contactsPage.isNewContactDisplayed(name), "New Contact create failed");
    }
}
