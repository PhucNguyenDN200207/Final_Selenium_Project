package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.ArticlePage;
import page.object.LoginPage;
import utils.Log4j;

import static helper.DataHelper.*;
import static utils.Constants.*;

public class TC_JOOMLA_ARTICLE_001 extends BaseTest {
    ArticlePage articlePage = new ArticlePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void login() {
        loginPage.login(USER_NAME, PASSWORD);

    }

    @Test(description = "Verify user can create new article with valid information")
    public void testcase001() {
        Log4j.header("TC_JOOMLA_ARTICLE_001");

        String title = randomTitle();
        String content = randomContent();

        Log4j.info("Select Content > Article Manager");
        articlePage.clickNewArticle();

        articlePage.createNewArticle(title, content, DEFAULT_ARTICLE_CATEGORY);

        articlePage.clickSaveBtn();

        Assert.assertEquals(articlePage.getAlertMessage(), ARTICLE_ALERT_MESSAGE, "Article Alert message failed");

        Log4j.info("Navigate to Article manager page");
        browserHelper.navigateToArticleManager();

        Assert.assertTrue(articlePage.isNewArticleTitleDisplayed(title), "Article title fail");

        Assert.assertEquals(articlePage.getAuthor(title), AUTHOR, "Author failed");


    }

}

