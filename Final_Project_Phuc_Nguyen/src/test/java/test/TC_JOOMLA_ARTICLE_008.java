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

        Log4j.info("Step: Go to Article manager page");
        articlePage.clickArticleManager();

        Log4j.info("Step: Click on'Help'icon of the top right toolbar");
        articlePage.clickHelpBtn();

        Log4j.info("Verify the article's help window is displayed");
        Assert.assertTrue(articlePage.doesHelpWindowDisplay(), "Help page title failed");
    }
}

