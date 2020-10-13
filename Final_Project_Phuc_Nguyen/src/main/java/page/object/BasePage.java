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
    final private By _formError = By.cssSelector(".message");

    private final By _loginTab = By.cssSelector("a[href^='/Account/Login']");
    private final By _logoutTab = By.cssSelector("a[href^='/Account/Logout']");
    private final By _changePasswordTab = By.cssSelector("a[href^='/Account/Change']");
    private final By _myTicketTab = By.cssSelector("a[href='/Page/ManageTicket.cshtml']");
    private final By _contactTab = By.cssSelector("a[href='/Page/Contact.cshtml']");
    private final By _registerTab = By.cssSelector("a[href='/Account/Register.cshtml']");


    /**
     * This is place create common Web elements
     */

    private WebElement loginTab() {
        return Constants.DRIVER.findElement(_loginTab);
    }

    private WebElement logoutTab() {
        return Constants.DRIVER.findElement(_logoutTab);
    }

    private WebElement contactTab() {
        return Constants.DRIVER.findElement(_contactTab);
    }

    private WebElement myTicketTab() {
        return Constants.DRIVER.findElement(_myTicketTab);
    }

    private WebElement registerTab() {
        return Constants.DRIVER.findElement(_registerTab);
    }

    private WebElement changePasswordTab() {
        return Constants.DRIVER.findElement(_changePasswordTab);
    }

    private WebElement formError() {
        return Constants.DRIVER.findElement(_formError);
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

    /**
     * Wait for element is clickable with time out 100 seconds
     *
     * @param element Element
     * @return Element
     */
    public WebElement waitElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Constants.DRIVER, 100);
        element = wait.until(ExpectedConditions.elementToBeClickable(By.id("usrUtils")));
        return element;
    }

    public String getTitle() {
        return Constants.DRIVER.getTitle();
    }

    public String getURL() {
        return Constants.DRIVER.getCurrentUrl();
    }

    public String formErrorMessage() {
        return formError().getText();
    }

    /**
     * Click on Menu Tab
     */
    public void clickLoginTab() {
        Log4j.info("Click on Login Tab");
        this.scrollToElement(loginTab()).click();
    }

    public void clickContactTab() {
        Log4j.info("Click on Contact Tab");
        this.scrollToElement(contactTab()).click();
    }

    public void clickMyTicketTab() {
        Log4j.info("Click on My Ticket Tab");
        this.scrollToElement(myTicketTab()).click();
    }

    public void clickChangePasswordTab() {
        Log4j.info("Click on Change Password Tab");
        this.scrollToElement(changePasswordTab()).click();
    }

    public void clickLogoutTab() {
        Log4j.info("Click on Logout Tab");
        this.scrollToElement(logoutTab()).click();
    }

    public void clickRegisterTab() {
        Log4j.info("Click on Register Tab");
        this.scrollToElement(registerTab()).click();
    }

    /**
     * Verify method
     */

    public Boolean isLoginTabDisplayed() {
        return isElementPresented(loginTab());
    }

    public Boolean isLogoutTabDisplayed() {
        return isElementPresented(logoutTab());
    }

    public Boolean isMyTicketTabDisplayed() {
        return isElementPresented(myTicketTab());
    }

    public Boolean isChangePasswordTabDisplayed() {
        return isElementPresented(changePasswordTab());
    }

    public Boolean isFormErrorDisplayed() {
        return isElementPresented(formError());
    }

}
