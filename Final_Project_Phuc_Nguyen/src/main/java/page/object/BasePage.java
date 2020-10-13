package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.Log4j;

import java.util.ArrayList;

import static utils.Constants.*;

public class BasePage {

    /**
     * Element locators of the common web elements' locator
     **/

    private final By _userName = By.cssSelector("#mod-login-username");
    private final By _password = By.cssSelector("#mod-login-password");
    private final By _loginBtn = By.cssSelector(".icon-white");
    private final By _saveBtn = By.cssSelector(".button-apply");
    private final By _alertSuccessMessage = By.cssSelector("div.alert-success .alert-message");
    private final By _helpBtn = By.cssSelector("#toolbar-help  button");

    /**
     * This is place create common Web elements
     */

    private WebElement userName() {
        return Constants.DRIVER.findElement(_userName);
    }

    private WebElement password() {
        return Constants.DRIVER.findElement(_password);
    }

    private WebElement loginBtn() {
        return Constants.DRIVER.findElement(_loginBtn);
    }

    private WebElement saveBtn() {
        return DRIVER.findElement(_saveBtn);
    }

    private WebElement alertSuccessMessage() {
        return DRIVER.findElement(_alertSuccessMessage);
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
    public void inputUserName(String userName) {
        userName().sendKeys(userName);
    }

    public void inputPassword(String password) {
        password().sendKeys(password);
    }

    public void clickLoginBtn() {
        Log4j.info("Click on Login Button");
        scrollToElement(loginBtn()).click();
    }

    public void clickSaveBtn() {
        Log4j.info("Step: Click on 'Save & Close' icon of the top right toolbar");
        scrollToElement(saveBtn()).click();
    }

    public void clickHelpBtn() {
        Log4j.info("Step: Click on 'Help' icon of the top right toolbar");
        helpBtn().click();
    }

    /**
     * input valid username and password to Joomla
     */
    public void login() {

        Log4j.info("Input to User Name text box: ");
        this.inputUserName(Constants.USER_NAME);

        Log4j.info("Input to Password text box: ");
        this.inputPassword(Constants.PASSWORD);

        clickLoginBtn();
    }

    public boolean verifyHelpPageTitle() throws InterruptedException {
        clickHelpBtn();
        Thread.sleep(TIME_OUT_SHORT);

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
