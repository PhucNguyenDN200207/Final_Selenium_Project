package page.object;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.Log4j;

import java.util.List;

import static utils.Constants.DRIVER;

public class BannersClientsPage extends BasePage {
    /**
     * This is place of Locator
     */

    private final By _bannerClients = By.xpath("//*[@id='submenu']/li/a[.='Clients']");
    private final By _emailTxt = By.cssSelector("#jform_email");
    private final By _contactNameTxt = By.cssSelector("#jform_contact");
    private final By _saveNewBtn = By.cssSelector(".button-save-new");
    private final String _newClientName = "//a[contains(.,'%s')]";
    private final String _checkBox = "//td//a[normalize-space(text())='%s']//ancestor::tr//input";
    private final String _boxName = "//td//a[normalize-space(text())='%s']//ancestor::tr//span[@class='icon-%s']";


    /**
     * This is place of Web Elements
     */

    private WebElement bannerClients() {
        return DRIVER.findElement(_bannerClients);
    }

    private WebElement emailTxt() {
        return DRIVER.findElement(_emailTxt);
    }

    private WebElement contactNameTxt() {
        return DRIVER.findElement(_contactNameTxt);
    }

    private WebElement newClientName(String name) {
        return elementByText(_newClientName, name);
    }

    private WebElement saveNewBtn() {
        return DRIVER.findElement(_saveNewBtn);
    }

    private List<WebElement> checkBox(String title) {
        return DRIVER.findElements(
                By.xpath(String.format(_checkBox, title)));
    }

    /**
     * This is place create methods
     */

    public void inputEmailTxt(String email) {
        Log4j.info("Input Email text field");
        emailTxt().sendKeys(email);
    }

    public void inputContactNameTxt(String name) {
        Log4j.info("Input Email text field");
        contactNameTxt().sendKeys(name);
    }

    public void clickBannerClients() {
        Log4j.info("Step: Click on Clients");
        bannerClients().click();
    }

    public void clickSaveNewBtn() {
        Log4j.info("Step: Click on Save & New button");
        saveNewBtn().click();
    }

    public void navigateToClientsPage() {
        clickComponentsMenu();
        clickBannersDrd();
        clickBannerClients();
    }

    /**
     * Create new Client for Banner
     *
     * @param title random Client title
     * @param name  random Client name
     * @param email radom Client email
     */
    public void createNewClient(String title, String name, String email) {
        inputNameTxt(title);
        inputContactNameTxt(name);
        inputEmailTxt(email);
    }

    public void selectCheckbox(String title) {
        if (checkBox(title).size() == 1){
            Constants.DRIVER.findElement(
                    By.xpath(String.format(_checkBox, title))).click();
        }
    }

    public boolean doesElementStatus(String title, String status) {
        return Constants.DRIVER.findElements(
                By.xpath(String.format(_boxName, title, status))).size() == 1;

    }

    public Boolean isNewClientTitleDisplayed(String title) {
        return isElementPresented(newClientName(title));
    }


    /**
     * This is place create verify methods
     */

}
