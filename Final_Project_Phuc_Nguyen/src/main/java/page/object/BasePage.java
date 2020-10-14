package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.Log4j;

import static utils.Constants.*;

public class BasePage {

    /**
     * Element locators of the common web elements' locator
     **/

    private final By _saveBtn = By.cssSelector(".button-apply");
    private final By _alertSuccessMsg = By.cssSelector("div.alert-success .alert-message");
    private final By _helpBtn = By.cssSelector("#toolbar-help  button");

    /**
     * This is place create common Web elements
     */

    private WebElement saveBtn() {
        return DRIVER.findElement(_saveBtn);
    }

    private WebElement alertSuccessMessage() {
        return DRIVER.findElement(_alertSuccessMsg);
    }

    private WebElement helpBtn() {
        return DRIVER.findElement(_helpBtn);
    }


    /**
     * Verify that web element is display or not by WebElement
     *
     * @return true if element is display or false if element is hidden
     */

    public boolean isElementPresented(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Used when needed to scroll down to the element needed to interact with
     * Firefox is not auto scroll to Element like Chrome and Edge
     */

    public WebElement scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Constants.DRIVER;
        js.executeScript("arguments[0].scrollIntoView();", element);
        return element;
    }

    public String getTitle() {
        return Constants.DRIVER.getTitle();
    }

    public String getURL() {
        return Constants.DRIVER.getCurrentUrl();
    }


    /**
     * Common method
     */

    public void clickSaveBtn() {
        Log4j.info("Step: Click on 'Save & Close' icon of the top right toolbar");
        scrollToElement(saveBtn()).click();
    }

    public void clickHelpBtn() {
        Log4j.info("Step: Click on 'Help' icon of the top right toolbar");
        helpBtn().click();
    }

    /**
     * Verify method
     */


    /**
     * Verify that the text is existed on page
     *
     * @param text string
     * @return true if text existed
     */
    public Boolean verifyTextOnPage(String text) {
        return Constants.DRIVER.getPageSource().contains(text);
    }

    public String getAlertMessage() {
        if (isElementPresented(alertSuccessMessage())) {
            return alertSuccessMessage().getText();
        } else return NO_MESSAGE_FOUND;

    }
}
