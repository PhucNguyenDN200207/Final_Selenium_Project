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

        Log4j.info("Step: Click on New Article on Menu");
        articlePage.clickNewArticle();

        Log4j.info("Step: Enter value on 'Article Text' text area");
        Log4j.info("Step: Enter value on 'Article Content' text area");
        Log4j.info("Step: Choose Default category on Dropdown");
        articlePage.enterNewArticle(title, content, DEFAULT_ARTICLE_CATEGORY);

        Log4j.info("Step: Click on'Save & Close'icon of the top right toolbar");
        articlePage.clickSaveAndCloseBtn();

        articlePage.chooseSortByIdDescending();

        Log4j.info("Verify: 'Article successfully saved' message is displayed");
        Assert.assertEquals(articlePage.getMessage(), ARTICLE_ALERT_MESSAGE, "Article Alert message failed");

        Log4j.info("Verify: Created article is displayed on the articles table");
        Assert.assertTrue(articlePage.isNewArticleTitleDisplayed(title), "Article title fail");

        Assert.assertEquals(articlePage.getAuthor(title), AUTHOR, "Author failed");

    }
}

