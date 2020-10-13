package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.ContactPage;
import utils.Constants;
import utils.Log4j;

public class ContactPageTest extends TestHelper {
    ContactPage contactPage = new ContactPage();

    @Test(priority = 1, testName = "TC_004", description = "Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog")
    public void testcase004() {
        Log4j.header("Testcase 004");

    }
}
