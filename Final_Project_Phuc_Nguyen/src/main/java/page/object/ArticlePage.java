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
    private final By _categoryDropdown = By.xpath("//div[@class='controls']/select[@id='jform_catid']/..");
    private final String _categoryOption = "//ul[@class='chzn-results']/li[contains(.,'%s')]";
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

    private WebElement categoryDropdown() {
        return DRIVER.findElement(_categoryDropdown);
    }

    private WebElement categoryOption(String option) {
        return DRIVER.findElement(By.xpath(String.format(_categoryOption, option)));
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

    public void selectCategory(String category) {
        clickWhenElementReady(categoryDropdown());
        clickWhenElementReady(categoryOption(category));
        Log4j.info("Selected: " + category);
    }

    public void clickIconPublish(String title) {
        Log4j.info("Step: Click on icon Publish with title: " + title);
        iconPublishByTitle(title).click();
    }

    public void clickIconUnPublish(String title) {
        Log4j.info("Step: Click on icon unPublish with title: " + title);
        iconUnPublishByTitle(title).click();
    }

    /***
     * Create New Article
     * @param title random Article Title
     * @param content random Article Content
     * @param articleCategory default Sample Data-Articles
     *  TODO function fail when create random data with special characters.
     */
    public void createNewArticle(String title, String content, String articleCategory) {
        Log4j.info("Enter a title on 'Title' field");
        inputArticleTitle(title);

        Log4j.info("Enter value on 'Article Text' text area");
        inputArticleContentTxt(content);

        Log4j.info("Select an item from the 'Category' dropdown list");
        selectCategory(articleCategory);
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

    public String getAuthor(String title) {
        return authorByNewTitle(title).getText();
    }
}
