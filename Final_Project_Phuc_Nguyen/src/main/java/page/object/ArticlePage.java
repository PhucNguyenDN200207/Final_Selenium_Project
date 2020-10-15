package page.object;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.Log4j;

import static utils.Constants.*;

public class ArticlePage extends BasePage {


    /**
     * This is place of Locator
     */
    private final By _newArticle = By.xpath("//div[@class='j-links-groups']//a[contains(.,'New Article')]");
    private final By _articleManager = By.xpath("//div[@class='j-links-groups']//a[contains(.,'Articles')]");
    private final By _articleTitle = By.cssSelector("#jform_title");
    private final By _articleContentTxt = By.cssSelector("#jform_articletext_ifr");
    private final String _iconPublish = "//tbody/tr//a[contains(.,'%s')]//ancestor::tr//div//a//span[@class='icon-publish']']";
    private final String _iconUnPublish = "//tbody/tr//a[contains(.,'%s')]//ancestor::tr//div//a//span[@class='icon-unpublish']']";
    private final String _newTitle = "//tbody/tr//a[contains(.,'%s')]";
    private final String _authorByNewTitle = "//tbody/tr//a[contains(.,'%s')]//ancestor::tr//td/a[@data-original-title='Author']";

    /**
     * This is place of Web Elements
     */
    private WebElement newArticle() {
        return DRIVER.findElement(_newArticle);
    }

    private WebElement articleManager() {
        return DRIVER.findElement(_articleManager);
    }

    private WebElement articleTitle() {
        return DRIVER.findElement(_articleTitle);
    }

    private WebElement articleContentTxt() {
        return DRIVER.findElement(_articleContentTxt);
    }

    private WebElement iconPublishByTitle(String title) {
        return elementByText(_iconPublish, title);
    }

    private WebElement iconUnPublishByTitle(String title) {
        return elementByText(_iconUnPublish, title);
    }

    private WebElement newTitle(String title) {
        return elementByText(_newTitle, title);
    }

    private WebElement authorByNewTitle(String author) {
        return elementByText(_authorByNewTitle, author);
    }

    /**
     * This is place create methods
     */
    public void clickNewArticle() {
        Log4j.info("Step: Click on New Article in Content Tab");
        newArticle().click();
    }

    public void inputArticleTitle(String title) {
        Log4j.info("Step: Input a title on 'Title' field");
        articleTitle().sendKeys(title);
    }

    public void inputArticleContentTxt(String text) {
        Log4j.info("Step: Input value on 'Article Text' text area");
        articleContentTxt().sendKeys(text);
    }


    public void clickArticleManager() {
        Log4j.info("Step: Click on Articles in Content Tab");
        articleManager().click();
    }

    public void clickIconPublish(String title) {
        Log4j.info("Step: Click on icon Publish with title: " + title);
        iconPublishByTitle(title).click();
    }

    public void clickIconUnPublish(String title) {
        Log4j.info("Step: Click on icon unPublish with title: " + title);
        iconUnPublishByTitle(title).click();
    }

    public void createNewArticle(String title, String content) {
        this.clickNewArticle();
        this.inputArticleTitle(title);
        this.inputArticleContentTxt(content);
        this.clickSaveBtn();
    }

    public void navigateToArticleManager() {
        BrowserHelper.navigate(Constants.JOOMLA_HOME_URL);
        clickArticleManager();
        chooseSortByIdDescending();
    }

    public void openHelpPage() {
        clickHelpBtn();
    }

    /**
     * This is place create verify methods
     */

    public Boolean isNewArticleTitleDisplayed(String title) {
        return isElementPresented(newTitle(title));
    }

    public Boolean isAuthorCorrected(String title) {
        return authorByNewTitle(title).getText().equals(AUTHOR);
    }
}
