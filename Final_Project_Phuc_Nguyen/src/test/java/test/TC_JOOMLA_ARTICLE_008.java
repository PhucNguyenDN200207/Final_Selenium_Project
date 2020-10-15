package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.ArticlePage;
import utils.Log4j;

public class TC_JOOMLA_ARTICLE_008 extends BaseTest {
    ArticlePage articlePage = new ArticlePage();

    @Test(description = "User can access article's help section")
    public void testcase008() throws InterruptedException {
        Log4j.header("TO_JOOMLA_ARTICLE_008");

        Log4j.info("Navigate to Article manager page");
        browserHelper.navigateToArticleManager();
        articlePage.openHelpPage();

        Assert.assertTrue(articlePage.doesHelpWindowDisplay(), "Help page title failed");
    }
}