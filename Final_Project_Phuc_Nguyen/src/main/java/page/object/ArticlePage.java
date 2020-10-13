package page.object;


import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Constants;
import utils.Log4j;

import java.util.ArrayList;

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
    private final By _helpBtn = By.cssSelector("#toolbar-help  button");
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


    private WebElement helpBtn() {
        return DRIVER.findElement(_helpBtn);
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

    public void clickHelpBtn() {
        Log4j.info("Step: Click on 'Help' icon of the top right toolbar");
        helpBtn().click();
    }

    public void clickArticleManager() {
        Log4j.info("Step: Click on Articles in Content Tab");
        articleManager().click();
    }

    public void clickIconPublish() {
        Log4j.info("Step: Click on the status icon of the selected article in the Status column");
        iconPublish().click();
    }

    public void createNewArticle() {
        this.clickNewArticle();
        this.inputArticleTitle(ARTICLE_TITLE);
        this.inputArticleContentTxt(ARTICLE_CONTENT_TEXT);
        this.clickSaveBtn();
    }

    public void navigateToArticleManager() {
        DriverHelper.navigate(Constants.JOOMLA_HOME_URL);
        clickArticleManager();
    }

    public boolean verifyHelpPageTitle() {
        clickHelpBtn();

        // Get all Open Tabs
        ArrayList<String> tabHandles = new ArrayList<String>(DRIVER.getWindowHandles());
        for (String eachHandle : tabHandles) {
            DRIVER.switchTo().window(eachHandle);
            // Check Help Page Title
            if (DRIVER.getTitle().equalsIgnoreCase(HELP_PAGE_TITLE)) {
                return true;
            }
        }
        return false;
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
