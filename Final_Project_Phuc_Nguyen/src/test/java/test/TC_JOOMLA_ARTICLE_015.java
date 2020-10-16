package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.ArticlePage;
import page.object.LoginPage;
import utils.Log4j;

import static helper.DataHelper.randomContent;
import static helper.DataHelper.randomTitle;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.Constants.*;

public class TC_JOOMLA_ARTICLE_015 extends BaseTest {
    ArticlePage articlePage = new ArticlePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void login() {
        loginPage.login(USER_NAME, PASSWORD);

    }

    @Test(description = "User can change the status of articles using the Status column")
    public void testcase015() {
        Log4j.header("TO_JOOMLA_ARTICLE_015");

        String title = randomTitle();
        String content = randomContent();
        // Verify Point 1: TO_JOOMLA_ARTICLE_001

        Log4j.info("Select Content > Article Manager");
        articlePage.clickNewArticle();

        articlePage.createNewArticle(title, content, DEFAULT_ARTICLE_CATEGORY);

        Log4j.info("Click on 'Save & Close' icon of the top right toolbar");
        articlePage.clickSaveBtn();

        Assert.assertEquals(articlePage.getAlertMessage(), ARTICLE_ALERT_MESSAGE, "Article Alert message failed");

        Log4j.info("Navigate to Article manager page");
        browserHelper.navigateToArticleManager();

        articlePage.chooseSortByIdDescending();

        Assert.assertTrue(articlePage.isNewArticleTitleDisplayed(title), "Article title fail");

        Assert.assertEquals(articlePage.getAuthor(title), AUTHOR, "Author failed");

        // Verify Point 2. A message : "1 client successfully unpublished" shows and Article is unpublished

        articlePage.selectCheckbox(title);

        articlePage.clickUnPublishBtn();


        assertEquals(articlePage.getAlertMessage(), ARTICLE_UNPUBLISHED_MESSAGE,
                "Unpublished failed ");

        assertTrue(articlePage.doesElementStatus(title,
                "unpublish"), "Element does not exist");

    }

}