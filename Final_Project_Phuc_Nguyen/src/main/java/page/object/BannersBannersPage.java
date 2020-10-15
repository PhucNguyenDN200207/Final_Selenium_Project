package page.object;

import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.Log4j;

import static utils.Constants.*;

public class BannersBannersPage extends BasePage {

    /**
     * This is place of Locator
     */

    private final By _bannerQuantity = By.cssSelector("#list_limit_chzn > a");
    private final By _bannerQuantity20 = By.xpath("//li[.='20']");
    private final String _newBanner = "//a[contains(.,'%s')]";
    private By _categoryDropdown = By.xpath("//div[@class='controls']/select[@id='jform_catid']/..");
    private String _dropdownOption = "//ul[@class='chzn-results']/li[contains(.,'%s')]";
    private By _bannerDetailsTab = By.cssSelector("div.form-horizontal li>a[href='#otherparams']");
    private By _clientDropdown = By.cssSelector("div[id='jform_cid_chzn']>a");


    /**
     * This is place of Web Elements
     */


    private WebElement bannerQuantity() {
        return DRIVER.findElement(_bannerQuantity);
    }

    private WebElement bannerQuantity20() {
        return DRIVER.findElement(_bannerQuantity20);
    }

    private WebElement newBannersBanner(String banner) {
        return elementByText(_newBanner, banner);
    }

    private WebElement categoryDropdown() {
        return DRIVER.findElement(_categoryDropdown);
    }

    private WebElement dropdownOption(String option) {
        return DRIVER.findElement(By.xpath(String.format(_dropdownOption, option)));
    }

    private WebElement bannerDetailsTab() {
        return DRIVER.findElement(_bannerDetailsTab);
    }

    private WebElement clientDropdown() {
        return DRIVER.findElement(_clientDropdown);
    }

    /**
     * This is place create methods
     */

    public void clickBannerQuantity() {
        Log4j.info("Step: Select quantity that user wants to display");
        bannerQuantity().click();
    }

    public void clickBannerQuantity20() {
        Log4j.info("Step: Select quantity : 20");
        bannerQuantity20().click();
    }

    public void createNewBanner(String bannerName, String categoryTitle, String clientTitle) {
        navigateToBannersPage();
        clickNewBtn();
        inputNameTxt(bannerName);
        clickWhenElementReady(categoryDropdown());
        clickWhenElementReady(dropdownOption(categoryTitle));
        Log4j.info("   Choose Category Dropdown: " + categoryTitle);
        clickWhenElementReady(bannerDetailsTab());
        clickWhenElementReady(clientDropdown());
        clickWhenElementReady(dropdownOption(clientTitle));
        Log4j.info("   Choose Client Dropdown: " + clientTitle);
        clickSaveBtn();
    }

    public void navigateToBannerManager() {
        DriverHelper.navigate(Constants.JOOMLA_HOME_URL);
        navigateToBannersPage();
        chooseSortByIdDescending();
    }

    public void selectQuantity20() {
        navigateToBannersPage();
        clickBannerQuantity();
        clickBannerQuantity20();
    }

    /**
     * This is place create verify methods
     */

    public Boolean verifyChooseQuantity20() {
        navigateToBannersPage();
        return bannerQuantity().getText().equals("20");
    }

    public Boolean isNewBannerDisplayed(String banner) {
        return isElementPresented(newBannersBanner(banner));
    }
}