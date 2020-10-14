package page.object;

import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.Log4j;

import static utils.Constants.DRIVER;

public class BannersClientsPage extends BasePage {
    /**
     * This is place of Locator
     */

    private final By _bannerClients = By.xpath("//*[@id='submenu']/li/a[.='Clients']");
    private final By _emailTxt = By.cssSelector("#jform_email");
    private final By _contactNameTxt = By.cssSelector("#jform_contact");
    private final By _firstClient = By.cssSelector(".nowrap div a ~ a");
    private final By _firstAuthor = By.xpath("//*[@id='articleList']/tbody/tr/td/div/a[@class='hasTooltip']");

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


    public void navigateToClientsPage() {
        clickComponentsMenu();
        clickBannersDrd();
        clickBannerClients();
    }


    public void createNewClient(String title, String name, String email) {
        navigateToClientsPage();
        clickNewBtn();
        inputNameTxt(title);
        inputContactNameTxt(name);
        inputEmailTxt(email);
        clickSaveBtn();
    }


    /**
     * This is place create verify methods
     */

    public Boolean verifyCreateNewClientSuccess() {
        DriverHelper.navigate(Constants.JOOMLA_HOME_URL);
        navigateToClientsPage();
        chooseSortByIdDescending();
        //TODO:
        return true;
    }

}