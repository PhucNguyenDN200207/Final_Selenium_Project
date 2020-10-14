package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.ArticlePage;
import page.object.LoginPage;
import utils.Log4j;

import static helper.NewTabHelper.verifyHelpPageTitle;


public class TO_JOOMLA_ARTICLE_008 extends TestHelper {
    ArticlePage articlePage = new ArticlePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void preCondition() {
        loginPage.login();
    }


    @Test(description = "User can access article's help section")
    public void testcase008() throws InterruptedException {
        Log4j.header("TO_JOOMLA_ARTICLE_008");

        Log4j.info("Navigate to Article manager page");
        articlePage.navigateToArticleManager();
        articlePage.openHelpPage();

        Assert.assertTrue(verifyHelpPageTitle(), "Help page title failed");
    }
}