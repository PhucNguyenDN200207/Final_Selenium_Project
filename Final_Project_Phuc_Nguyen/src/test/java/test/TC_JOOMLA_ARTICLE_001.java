package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.ArticlePage;
import utils.Log4j;

import static helper.DataHelper.*;
import static utils.Constants.*;

public class TC_JOOMLA_ARTICLE_001 extends BaseTest {
    ArticlePage articlePage = new ArticlePage();

    @Test(description = "Verify user can create new article with valid information")
    public void testcase001() {
        Log4j.header("TC_JOOMLA_ARTICLE_001");

        String title = randomTitle();
        String content = randomContent();

        articlePage.createNewArticle(title, content, DEFAUT_ARTICLE_CATEGORY);

        // Assert.assertEquals(articlePage.getAlertMessage(), ARTICLE_ALERT_MESSAGE, "Article Alert message failed");

        Log4j.info("Navigate to Article manager page");
        articlePage.navigateToArticleManager();

        Assert.assertTrue(articlePage.isNewArticleTitleDisplayed(title), "Article title fail");
        Assert.assertTrue(articlePage.isAuthorCorrected(title), "Author failed");
    }
}
