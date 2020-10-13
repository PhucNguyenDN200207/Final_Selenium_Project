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
    private final By _articleTitle = By.cssSelector("#jform_title");
    private final By _articleContentTxt = By.cssSelector("#jform_articletext_ifr");
    private final By _saveBtn = By.cssSelector(".button-apply");
    private final By _alertMessage = By.cssSelector("div.alert-success .alert-message");
    private final By _firstAuthor = By.xpath("//*[@id='articleList']/tbody/tr/td/a");
    private final By _firstTitle = By.xpath("//*[@id=\"articleList\"]/tbody/tr/td/div/a[@class='hasTooltip']");

    /**
     * This is place of Web Elements
     */
    private WebElement newArticle() {
        return DRIVER.findElement(_newArticle);
    }

    private WebElement articleTitle() {
        return DRIVER.findElement(_articleTitle);
    }


    private WebElement articleContentTxt() {
        return DRIVER.findElement(_articleContentTxt);
    }

    private WebElement saveBtn() {
        return DRIVER.findElement(_saveBtn);
    }

    private WebElement alertMessage() {
        return DRIVER.findElement(_alertMessage);
    }

    private WebElement firstTitle() {
        return DRIVER.findElement((_firstTitle));
    }

    private WebElement firstAuthor() {
        return DRIVER.findElement((_firstAuthor));
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


    public void clickSaveBtn() {
        Log4j.info("Step: Click on 'Save & Close' icon of the top right toolbar");
        scrollToElement(saveBtn()).click();
    }

    public void createNewArticle() {
        this.clickNewArticle();
        this.inputArticleTitle(ARTICLE_TITLE);
        this.inputArticleContentTxt(ARTICLE_CONTENT_TEXT);
        this.clickSaveBtn();
    }

    /**
     * This is place create verify methods
     */
    public String getAlertMessage() {
        return alertMessage().getText();
    }

    public String getFirstAuthor() {
        return firstAuthor().getText();
    }

    public String getFirstTitle() {
        return firstTitle().getText();
    }
}
