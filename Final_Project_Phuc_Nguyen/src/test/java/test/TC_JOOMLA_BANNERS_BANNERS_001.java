package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.BannersPage;
import page.object.ContactsPage;
import page.object.LoginPage;
import utils.Log4j;

import static utils.Constants.CONTACT_SUCCESS_MESSAGE;

public class TC_JOOMLA_BANNERS_BANNERS_001 extends BaseTest {
    BannersPage bannersPage = new BannersPage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void preCondition() {
        loginPage.login();
    }


    @Test(description = "User can create new contact with valid information")
    public void testcase001() {
        Log4j.header("TC_JOOMLA_CONTACTS_001");

        bannersPage.createNewBanner();
        Assert.assertEquals(bannersPage.getAlertMessage(),
                CONTACT_SUCCESS_MESSAGE, "Banners Alert message failed");

        //TODO: Not finished yet
    }
}
