package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.ArticlePage;
import utils.Log4j;


public class TC_JOOMLA_ARTICLE_008 extends TestHelper {
    ArticlePage articlePage = new ArticlePage();

    @BeforeMethod
    public void preCondition() {
        articlePage.login();
    }

    @Test(testName = "TC_008", description = "User can access article's help section")
    public void testcase008() {
        Log4j.header("Testcase 008");

        Log4j.info("Navigate to Article manager page");
        articlePage.navigateToArticleManager();
        //Fail at FireFox
        Assert.assertTrue(articlePage.verifyHelpPageTitle(), "Help page title failed");
    }
}