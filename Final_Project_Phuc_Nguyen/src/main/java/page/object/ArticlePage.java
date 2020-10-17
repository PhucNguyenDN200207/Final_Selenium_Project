package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    private final String _newTitle = "//td//a[normalize-space(text())='%s']";
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
        newArticle().click();
    }

    public void inputArticleTitle(String title) {
        articleTitle().sendKeys(title);
    }

    public void inputArticleContentTxt(String text) {
        articleContentTxt().sendKeys(text);
    }


    public void clickArticleManager() {
        articleManager().click();
    }

    /***
     * Create New Article
     * @param title random Article Title
     * @param content random Article Content
     * @param articleCategory default Sample Data-Articles
     *  TODO function fail when create random data with special characters.
     */
    public void enterNewArticle(String title, String content, String articleCategory) {
        inputArticleTitle(title);

        inputArticleContentTxt(content);

        selectCategory(articleCategory);
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
