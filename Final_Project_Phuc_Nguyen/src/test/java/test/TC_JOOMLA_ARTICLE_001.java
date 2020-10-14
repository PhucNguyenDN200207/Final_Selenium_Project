package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.ArticlePage;
import page.object.LoginPage;
import utils.Log4j;

import static helper.DataHelper.*;
import static utils.Constants.*;

public class TC_JOOMLA_ARTICLE_001 extends TestHelper {
    ArticlePage articlePage = new ArticlePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void preCondition() {
        loginPage.login();
    }

    @Test(description = "Verify user can create new article with valid information")
    public void testcase001() {
        Log4j.header("TC_JOOMLA_ARTICLE_001");

        String title = randomTitle();
        String content = randomContent();

        articlePage.createNewArticle(title, content);

        Assert.assertEquals(articlePage.getAlertMessage(), ARTICLE_ALERT_MESSAGE, "Alert message failed");

        Log4j.info("Navigate to Article manager page");
        articlePage.navigateToArticleManager();

        Assert.assertEquals(articlePage.getFirstAuthor(), AUTHOR, "Author failed");
        Assert.assertEquals(articlePage.getFirstTitle(), title, "Article title fail");
    }
}
