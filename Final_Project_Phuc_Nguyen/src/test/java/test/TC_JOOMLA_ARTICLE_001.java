package test;

import helper.DriverHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.ArticlePage;
import utils.Log4j;

import static utils.Constants.*;

public class TC_JOOMLA_ARTICLE_001 extends TestHelper {
    ArticlePage articlePage = new ArticlePage();

    @BeforeMethod
    public void preCondition() {
        articlePage.login();
    }

    @Test(description = "Verify user can create new article with valid information")
    public void testcase001() {
        Log4j.header("TC_JOOMLA_ARTICLE_001");
        articlePage.createNewArticle();

        Assert.assertEquals(articlePage.getAlertMessage(), ARTICLE_ALERT_MESSAGE, "Alert message failed");

        Log4j.info("Navigate to Article manager page");
        articlePage.navigateToArticleManager();

        Assert.assertEquals(articlePage.getFirstAuthor(), AUTHOR, "Author failed");
        Assert.assertEquals(articlePage.getFirstTitle(), ARTICLE_TITLE, "Article title fail");
    }
}
