package page.object;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import utils.Log4j;

import static utils.Constants.*;


public class LoginPage extends BasePage {

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
        return DRIVER.findElement(_userName);
    }

    private WebElement password() {
        return DRIVER.findElement(_password);
    }

    private WebElement loginBtn() {
        return DRIVER.findElement(_loginBtn);
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
        loginBtn().click();
    }

    /**
     * Login with input valid username and password to Joomla
     */
    public void login(String username, String password) {

        Log4j.info("Enter valid username into Username field");
        this.inputUserName(username);

        Log4j.info("Enter valid password into Password field");
        this.inputPassword(password);

        clickLoginBtn();
    }

}
