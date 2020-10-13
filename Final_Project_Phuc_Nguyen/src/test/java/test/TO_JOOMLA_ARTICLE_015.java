package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.ArticlePage;
import utils.Log4j;

import static utils.Constants.*;

public class TO_JOOMLA_ARTICLE_015 extends TestHelper {
    ArticlePage articlePage = new ArticlePage();

    @BeforeMethod
    public void preCondition() {
        articlePage.login();
    }

    @Test(description = "User can change the status of articles using the Status column")
    public void testcase015() {
        Log4j.header("TO_JOOMLA_ARTICLE_015");
        articlePage.createNewArticle();

        Assert.assertEquals(articlePage.getAlertMessage(), ARTICLE_ALERT_MESSAGE, "Alert message failed");

        Log4j.info("Navigate to Article manager page");
        articlePage.navigateToArticleManager();

        Assert.assertEquals(articlePage.getFirstAuthor(), AUTHOR, "Author failed");
        Assert.assertEquals(articlePage.getFirstTitle(), ARTICLE_TITLE, "Article title fail");

        //Not finish yet

    }
}