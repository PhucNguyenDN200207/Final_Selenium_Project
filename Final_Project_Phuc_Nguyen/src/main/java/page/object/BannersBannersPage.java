package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log4j;

import java.util.List;

import static utils.Constants.*;

public class BannersBannersPage extends BasePage {

    /**
     * This is place of Locator
     */

    private final By _bannerQuantity = By.cssSelector("#list_limit_chzn > a");
    private final String _bannerQuantitySelect = "//li[.='%s']";
    private final String _newBanner = "//a[contains(.,'%s')]";
    private final By _categoryDropdown = By.xpath("//div[@class='controls']/select[@id='jform_catid']/..");
    private final String _dropdownOption = "//ul[@class='chzn-results']/li[contains(.,'%s')]";
    private final By _bannerDetailsTab = By.cssSelector("div.form-horizontal li>a[href='#otherparams']");
    private final By _clientDropdown = By.cssSelector("div[id='jform_cid_chzn']>a");
    private final By _numberTableRows = By.xpath("//*[@id=\"articleList\"]/tbody/tr");

    /**
     * This is place of Web Elements
     */


    private WebElement bannerQuantity() {
        return DRIVER.findElement(_bannerQuantity);
    }

    private WebElement bannerQuantitySelect(String number) {
        return elementByText(_bannerQuantitySelect, number);
    }

    private WebElement newBannersBanner(String banner) {
        return elementByText(_newBanner, banner);
    }

    private WebElement categoryDropdown() {
        return DRIVER.findElement(_categoryDropdown);
    }

    private WebElement dropdownOption(String option) {
        return elementByText(_dropdownOption, option);
    }

    private WebElement bannerDetailsTab() {
        return DRIVER.findElement(_bannerDetailsTab);
    }

    private WebElement clientDropdown() {
        return DRIVER.findElement(_clientDropdown);
    }

    private List<WebElement> numberTableRows() {
        return DRIVER.findElements(_numberTableRows);
    }

    /**
     * This is place create methods
     */

    public void clickBannerQuantity() {
        Log4j.info("Step: Select quantity that user wants to display");
        bannerQuantity().click();
    }

    public void clickBannerQuantitySelect(String number) {
        Log4j.info("Step: Select quantity : 20");
        bannerQuantitySelect(number).click();
    }

    public String getNumberTableRows() {
        return String.valueOf(numberTableRows().size());
    }

    /**
     * Create New Banner
     *
     * @param bannerName    random Banner Name
     * @param categoryTitle choose from dropdown Category
     * @param clientTitle   choose from dropdown Client
     */
    public void createNewBanner(String bannerName, String categoryTitle, String clientTitle) {
        inputNameTxt(bannerName);

        clickWhenElementReady(categoryDropdown());
        clickWhenElementReady(dropdownOption(categoryTitle));
        Log4j.info("Choose Category Dropdown: " + categoryTitle);

        clickWhenElementReady(bannerDetailsTab());
        clickWhenElementReady(clientDropdown());
        clickWhenElementReady(dropdownOption(clientTitle));
        Log4j.info("Choose Client Dropdown: " + clientTitle);
    }

    /**
     * Choose value 20 option as testcase Banner Banner 15 asked for
     */
    public void selectQuantityNumber(String num) {
        clickComponentsMenu();
        clickBannersDrd();
        clickBannerQuantity();
        clickBannerQuantitySelect(num);
    }

    /**
     * This is place create verify methods
     */

    public Boolean verifyChooseQuantityNumber(String num) {
        return getNumberTableRows().equals(num);
    }

    public Boolean isNewBannerDisplayed(String banner) {
        return isElementPresented(newBannersBanner(banner));
    }
}