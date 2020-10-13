package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;
import utils.Log4j;

public class BasePage {

    /**
     * Element locators of the common web elements' locator
     **/
    private final By _userName = By.cssSelector("#mod-login-username");
    private final By _password = By.cssSelector("#mod-login-password");
    private final By _loginBtn = By.cssSelector(".icon-white");


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
        scrollToElement(userName()).sendKeys(userName);
    }

    public void inputPassword(String password) {
        scrollToElement(password()).sendKeys(password);
    }

    public void clickLoginBtn() {
        Log4j.info("Click on Login Button");
        scrollToElement(loginBtn()).click();
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

    /**
     * Verify method
     */
    /**
     * Verify that the text is existed on page
     * @param text string
     * @return true if text existed
     */
    public Boolean verifyTextOnPage(String text) {
        return Constants.DRIVER.getPageSource().contains(text);
    }
}
