package page.object;


import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Constants;
import utils.Log4j;


import static helper.DataHelper.*;
import static utils.Constants.*;

public class ArticlePage extends BasePage {


    /**
     * This is place of Locator
     */
    private final By _newArticle = By.xpath("//div[@class='j-links-groups']//a[contains(.,'New Article')]");
    private final By _articleManager = By.xpath("//div[@class='j-links-groups']//a[contains(.,'Articles')]");
    private final By _articleTitle = By.cssSelector("#jform_title");
    private final By _articleContentTxt = By.cssSelector("#jform_articletext_ifr");
    private final By _firstAuthor = By.xpath("//*[@id='articleList']/tbody/tr/td/a");
    private final By _firstTitle = By.xpath("//*[@id='articleList']/tbody/tr/td/div/a[@class='hasTooltip']");
    private final By _iconPublish = By.xpath("//tbody//span[@class='icon-publish']");

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

    private WebElement firstTitle() {
        return DRIVER.findElement(_firstTitle);
    }

    private WebElement firstAuthor() {
        return DRIVER.findElement(_firstAuthor);
    }

    private WebElement iconPublish() {
        return DRIVER.findElement(_iconPublish);
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
        scrollToElement(articleTitle()).sendKeys(title);
    }

    public void inputArticleContentTxt(String text) {
        Log4j.info("Step: Input value on 'Article Text' text area");
        scrollToElement(articleContentTxt()).sendKeys(text);
    }


    public void clickArticleManager() {
        Log4j.info("Step: Click on Articles in Content Tab");
        articleManager().click();
    }

    public void clickIconPublish() {
        Log4j.info("Step: Click on the status icon of the selected article in the Status column");
        iconPublish().click();
    }

    public void createNewArticle(String title, String content) {
        this.clickNewArticle();
        this.inputArticleTitle(title);
        this.inputArticleContentTxt(content);
        this.clickSaveBtn();
    }

    public void navigateToArticleManager() {
        DriverHelper.navigate(Constants.JOOMLA_HOME_URL);
        clickArticleManager();
    }

    public void openHelpPage() {
        clickHelpBtn();
    }

    /**
     * This is place create verify methods
     */

    public String getFirstAuthor() {
        return firstAuthor().getText();
    }

    public String getFirstTitle() {
        return firstTitle().getText();
    }
}