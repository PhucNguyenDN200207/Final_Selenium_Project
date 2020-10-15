package test;

import helper.BrowserHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.ArticlePage;
import utils.Log4j;

import static helper.DataHelper.randomContent;
import static helper.DataHelper.randomTitle;
import static utils.Constants.*;

public class TC_JOOMLA_ARTICLE_015 extends BaseTest {
    ArticlePage articlePage = new ArticlePage();

    @Test(description = "User can change the status of articles using the Status column")
    public void testcase015() {
        Log4j.header("TO_JOOMLA_ARTICLE_015");

        String title = randomTitle();
        String content = randomContent();

        Log4j.info("Select Content > Article Manager");
        articlePage.clickNewArticle();


        articlePage.createNewArticle(title, content, DEFAUT_ARTICLE_CATEGORY);

        Log4j.info("Click on 'Save & Close' icon of the top right toolbar");
        articlePage.clickSaveBtn();

        Assert.assertEquals(articlePage.getAlertMessage(), ARTICLE_ALERT_MESSAGE, "Article Alert message failed");

        Log4j.info("Navigate to Article manager page");
        browserHelper.navigateToArticleManager();
        articlePage.chooseSortByIdDescending();

        Assert.assertTrue(articlePage.isNewArticleTitleDisplayed(title), "Article title fail");
        Assert.assertEquals(articlePage.getAuthor(title), AUTHOR, "Author failed");

        //TODO: Publish and un Publish

    }
}