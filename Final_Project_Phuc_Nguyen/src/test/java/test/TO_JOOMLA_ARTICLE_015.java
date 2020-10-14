package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.ArticlePage;
import page.object.LoginPage;
import utils.Log4j;

import static helper.DataHelper.randomContent;
import static helper.DataHelper.randomTitle;
import static utils.Constants.*;

public class TO_JOOMLA_ARTICLE_015 extends TestHelper {
    ArticlePage articlePage = new ArticlePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void preCondition() {
        loginPage.login();
    }

    @Test(description = "User can change the status of articles using the Status column")
    public void testcase015() {
        Log4j.header("TO_JOOMLA_ARTICLE_015");

        String title = randomTitle();
        String content = randomContent();

        articlePage.createNewArticle(title, content);

        Assert.assertEquals(articlePage.getAlertMessage(), ARTICLE_ALERT_MESSAGE, "Alert message failed");

        Log4j.info("Navigate to Article manager page");
        articlePage.navigateToArticleManager();

        Assert.assertEquals(articlePage.getFirstAuthor(), AUTHOR, "Author failed");
        Assert.assertEquals(articlePage.getFirstTitle(), title, "Article title fail");

        //Not finish yet

    }
}