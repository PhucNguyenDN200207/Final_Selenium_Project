package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    /**
     * This is place create methods
     */

    public void enterEmailTxt(String email) {
        emailTxt().sendKeys(email);
    }

    public void enterContactNameTxt(String name) {
        contactNameTxt().sendKeys(name);
    }

    public void clickBannerClients() {
        bannerClients().click();
    }

    public void clickSaveNewBtn() {
        saveNewBtn().click();
    }

    /**
     * Create new Client for Banner
     *
     * @param title random Client title
     * @param name  random Client name
     * @param email radom Client email
     */
    public void enterNewClient(String title, String name, String email) {
        enterNameTxt(title);
        enterContactNameTxt(name);
        enterEmailTxt(email);
    }


    public Boolean isNewClientTitleDisplayed(String title) {
        return isElementPresented(newClientName(title));
    }
}
