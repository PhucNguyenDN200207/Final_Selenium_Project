package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.ArticlePage;
import page.object.LoginPage;
import utils.Log4j;

import static utils.Constants.PASSWORD;
import static utils.Constants.USER_NAME;

public class TC_JOOMLA_ARTICLE_008 extends BaseTest {
    ArticlePage articlePage = new ArticlePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void login() {
        loginPage.login(USER_NAME, PASSWORD);

    }

    @Test(description = "User can access article's help section")
    public void testcase008() {
        Log4j.header("TO_JOOMLA_ARTICLE_008");

        Log4j.info("Navigate to Article manager page");

        browserHelper.navigateToArticleManager();

        articlePage.clickHelpBtn();

        Assert.assertTrue(articlePage.doesHelpWindowDisplay(), "Help page title failed");
    }
}
