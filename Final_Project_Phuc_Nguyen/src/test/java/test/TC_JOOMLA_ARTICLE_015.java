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

        Log4j.info("Step: Click on New Article on Menu");
        articlePage.clickNewArticle();

        Log4j.info("Step: Enter value on 'Article Text' text area");
        Log4j.info("Step: Enter value on 'Article Content' text area");
        Log4j.info("Step: Choose Default category on Dropdown");
        articlePage.enterNewArticle(title, content, DEFAULT_CONTACT_CATEGORY);

        Log4j.info("Step: Click on'Save & Close'icon of the top right toolbar");
        articlePage.clickSaveAndCloseBtn();

        articlePage.chooseSortByIdDescending();

        Log4j.info("Verify: 'Article successfully saved' message is displayed");
        Assert.assertEquals(articlePage.getMessage(), ARTICLE_ALERT_MESSAGE, "Article Alert message failed");

        Log4j.info("Verify: Created article is displayed on the articles table");
        Assert.assertTrue(articlePage.isNewArticleTitleDisplayed(title), "Article title fail");

        Assert.assertEquals(articlePage.getAuthor(title), AUTHOR, "Author failed");

        // Verify Point 2. A message : "1 client successfully unpublished" shows and Article is unpublished

        Log4j.info("Step: Check on the recently added article's checkbox");
        articlePage.selectCheckbox(title);

        Log4j.info("Step: Click on the status icon of the selected article in the Status column");
        articlePage.clickUnPublishBtn();

        Log4j.info("Verify: The '1 article unpublished' message is displayed");

        assertEquals(articlePage.getMessage(), ARTICLE_UNPUBLISHED_MESSAGE,
                "Unpublished failed ");

        Log4j.info("Verify: The icon of the selected item is showed as 'Unpublish'. ");
        assertTrue(articlePage.doesElementStatus(title,
                "unpublish"), "Element does not exist");
    }

}