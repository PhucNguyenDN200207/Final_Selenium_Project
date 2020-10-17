package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.ContactsPage;
import page.object.LoginPage;
import utils.Log4j;

import static helper.DataHelper.randomName;
import static utils.Constants.*;

public class TC_JOOMLA_CONTACTS_001 extends BaseTest {
    ContactsPage contactsPage = new ContactsPage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void login() {
        loginPage.login(USER_NAME, PASSWORD);

    }

    @Test(description = "User can create new contact with valid information")
    public void testcase001() {
        Log4j.header("TC_JOOMLA_CONTACTS_001");
        String name = randomName();

        Log4j.info("Step: Select Components > Contacts");
        contactsPage.clickComponentsMenu();

        contactsPage.clickContactDrd();

        Log4j.info("Step: Click on 'New' icon of the top right toolbar");
        contactsPage.clickNewBtn();

        Log4j.info("Step: Enter a title on 'Name' field");
        contactsPage.enterNewContact(name);

        Log4j.info("Step: Select an item from the 'Category' dropdown list");
        contactsPage.selectCategory(DEFAULT_CONTACT_CATEGORY);

        Log4j.info("Click on 'Save & Close' icon of the top right toolbar");
        contactsPage.clickSaveAndCloseBtn();

        Log4j.info("Verify: 'Contact successfully saved' message is displayed");
        Assert.assertEquals(contactsPage.getMessage(),
                CONTACT_SUCCESS_MESSAGE, "Contact Alert message failed");

        contactsPage.chooseSortByIdDescending();

        Log4j.info("Verify: Created contact is displayed on the contacts table");
        Assert.assertTrue(contactsPage.isNewContactDisplayed(name), "New Contact create failed");
    }
}
