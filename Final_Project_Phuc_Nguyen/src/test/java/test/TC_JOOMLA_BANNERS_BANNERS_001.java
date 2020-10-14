package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.BannersPage;
import utils.Log4j;

import static utils.Constants.CONTACT_SUCCESS_MESSAGE;

public class TC_JOOMLA_BANNERS_BANNERS_001 extends BaseTest {
    BannersPage bannersPage = new BannersPage();

    @Test(description = "User can create new contact with valid information")
    public void testcase001() {
        Log4j.header("TC_JOOMLA_CONTACTS_001");

        bannersPage.createNewBanner();
        Assert.assertEquals(bannersPage.getAlertMessage(),
                CONTACT_SUCCESS_MESSAGE, "Banners Alert message failed");

        //TODO: Not finished yet
    }
}
