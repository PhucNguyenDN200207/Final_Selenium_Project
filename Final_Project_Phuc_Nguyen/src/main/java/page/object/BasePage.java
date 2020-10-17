package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;
import utils.Log4j;

import java.util.List;

import static helper.BrowserHelper.doesNewWindowDisplay;
import static utils.Constants.*;

public class BasePage {

    /**
     * Element locators of the common web elements' locator
     **/

    private final By _componentsMenu = By.xpath("//*[@id='menu']/li//a[contains(.,'Components')]");
    private final By _bannersOpt = By.xpath("//li[@class='dropdown open']//li[@class='dropdown-submenu']/a[.='Banners']");
    private final By _saveBtn = By.cssSelector(".button-apply");
    private final By _alertSuccessMsg = By.cssSelector(".alert-message");
    private final By _helpBtn = By.cssSelector("#toolbar-help  button");
    private final By _newBtn = By.cssSelector(".button-new");
    private final By _searchBtn = By.cssSelector(".icon-search");
    private final By _saveAndCloseBtn = By.xpath("//*[@id='toolbar-save']");
    private final By _nameTxt = By.cssSelector("#jform_name");
    private final By _titleTxt = By.cssSelector("#jform_title");
    private final By _searchTxt = By.cssSelector("#filter_search");
    private final By _categoryDropdown = By.xpath("//div[@class='controls']/select[@id='jform_catid']/..");
    private final String _categoryOption = "//ul[@class='chzn-results']/li[contains(.,'%s')]";
    private final String _checkBox = "//td//a[normalize-space(text())='%s']//ancestor::tr//input";
    private final String _boxName = "//td//a[normalize-space(text())='%s']//ancestor::tr//span[@class='icon-%s']";
    private final By _sortByDrd = By.xpath("//*[@id='list_fullordering_chzn']/a");
    private final By _sortByIdDescending = By.xpath("//li[.='ID descending']");
    private final By _unPublishBtn = By.id("toolbar-unpublish");

    /**
     * This is place create common Web elements
     */

    private WebElement saveBtn() {
        return DRIVER.findElement(_saveBtn);
    }

    private WebElement saveAndCloseBtn() {
        return DRIVER.findElement(_saveAndCloseBtn);
    }

    private WebElement alertSuccessMessage() {
        return DRIVER.findElement(_alertSuccessMsg);
    }

    private WebElement helpBtn() {
        return DRIVER.findElement(_helpBtn);
    }

    private WebElement searchBtn() {
        return DRIVER.findElement(_searchBtn);
    }

    private WebElement componentsMenu() {
        return DRIVER.findElement(_componentsMenu);
    }

    private WebElement bannersOpt() {
        return DRIVER.findElement(_bannersOpt);
    }

    private WebElement newBtn() {
        return DRIVER.findElement(_newBtn);
    }

    private WebElement nameTxt() {
        return DRIVER.findElement(_nameTxt);
    }

    private WebElement titleTxt() {
        return DRIVER.findElement(_titleTxt);
    }

    private WebElement searchTxt() {
        return DRIVER.findElement(_searchTxt);
    }

    private List<WebElement> checkBox(String title) {
        return DRIVER.findElements(
                By.xpath(String.format(_checkBox, title)));
    }

    private List<WebElement> boxName(String title, String status) {
        return DRIVER.findElements(
                By.xpath(String.format(_boxName, title, status)));
    }

    private WebElement sortByDrd() {
        return DRIVER.findElement(_sortByDrd);
    }

    private WebElement sortByIdDescending() {
        return DRIVER.findElement(_sortByIdDescending);
    }

    private WebElement categoryDropdown() {
        return DRIVER.findElement(_categoryDropdown);
    }

    private WebElement categoryOption(String option) {
        return DRIVER.findElement(By.xpath(String.format(_categoryOption, option)));
    }

    /***
     * This method choose Web Element by String Test
     * @param element for example: "//tbody/tr//a[contains(.,'%s')]"
     * @param text title
     * @return Web Element identify by Xpath title
     */
    public WebElement elementByText(String element, String text) {
        return DRIVER.findElement(By.xpath(String.format(element, text)));
    }

    /**
     * Verify that web element is display or not by WebElement
     *
     * @return true if element is display or false if element is not attach to DOM
     */

    public boolean isElementPresented(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickUnPublishBtn() {
        Constants.DRIVER.findElement(_unPublishBtn).click();
    }

    public void clickSaveAndCloseBtn() {
        saveAndCloseBtn().click();
    }

    public void clickHelpBtn() {
        helpBtn().click();
    }

    public void clickSearchBtn() {
        searchBtn().click();
    }

    public void clickComponentsMenu() {
        componentsMenu().click();
    }

    public void clickBannersOpt() {
        bannersOpt().click();
    }

    public void clickNewBtn() {
        newBtn().click();
    }

    public void clickSortByDrd() {
        sortByDrd().click();
    }

    public void clickSortByIdDescending() {
        sortByIdDescending().click();
    }

    public void clickWhenElementReady(WebElement element) {
        waitUntilVisible(element);
        waitUntilClickable(element);
        element.click();
    }

    public void waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DRIVER, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DRIVER, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public int sizeOfCheckbox(String title) {
        return checkBox(title).size();
    }

    public void selectCheckbox(String title) {
        if (sizeOfCheckbox(title) == 1) {
            checkBox(title).get(0).click();
        }
    }

    public void selectCategory(String category) {
        clickWhenElementReady(categoryDropdown());
        clickWhenElementReady(categoryOption(category));
        Log4j.info("Selected: " + category);
    }

    public boolean doesElementStatus(String title, String status) {
        return boxName(title, status).size() == 1;

    }

    public void enterNameTxt(String name) {
        clickWhenElementReady(nameTxt());
        nameTxt().sendKeys(name);
    }

    public void enterTitleTxt(String title) {
        titleTxt().sendKeys(title);
    }

    public void enterSearch(String text) {
        searchTxt().sendKeys(text);
    }

    /**
     * Choose sort By ID Descending to pop-up every new create element to first row of data table
     */
    public void chooseSortByIdDescending() {
        clickSortByDrd();
        Log4j.info("Sort table data by ID Descending");
        clickSortByIdDescending();
    }

    /**
     * Return every successful message in JOOMLA
     *
     * @return String success message if message element is displayed, if not return NO MESSAGE FOUND
     */
    public String getMessage() {
        if (isElementPresented(alertSuccessMessage())) {
            return alertSuccessMessage().getText();
        } else return ELEMENT_MESSAGE_NOT_FOUND;
    }

    /**
     * Verify method
     */

    public Boolean doesHelpWindowDisplay() {
        return doesNewWindowDisplay(HELP_PAGE_TITLE, 2);
    }
}
