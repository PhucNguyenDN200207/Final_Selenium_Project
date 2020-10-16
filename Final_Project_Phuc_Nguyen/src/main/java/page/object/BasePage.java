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
    private final By _bannersDrd = By.xpath("//li[@class='dropdown open']//li[@class='dropdown-submenu']/a[.='Banners']");
    private final By _saveBtn = By.cssSelector(".button-apply");
    private final By _alertSuccessMsg = By.cssSelector("div.alert-success .alert-message");
    private final By _helpBtn = By.cssSelector("#toolbar-help  button");
    private final By _newBtn = By.cssSelector(".button-new");
    private final By _searchBtn = By.cssSelector(".icon-search");
    private final By _saveAndCloseBtn = By.xpath("//*[@id='toolbar-save']");
    private final By _nameTxt = By.cssSelector("#jform_name");
    private final By _titleTxt = By.cssSelector("#jform_title");
    private final By _searchTxt = By.cssSelector("#filter_search");
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

    private WebElement bannersDrd() {
        return DRIVER.findElement(_bannersDrd);
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

    private WebElement sortByDrd() {
        return DRIVER.findElement(_sortByDrd);
    }

    private WebElement sortByIdDescending() {
        return DRIVER.findElement(_sortByIdDescending);
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
        Log4j.info("Step: Click UnPublish with the title  ");
        Constants.DRIVER.findElement(_unPublishBtn).click();
    }

    public void clickSaveBtn() {
        Log4j.info("Step: Click on 'Save' icon of the top right toolbar");
        saveBtn().click();
    }

    public void clickSaveAndCloseBtn() {
        Log4j.info("Step: Click on 'Save & Close' icon of the top right toolbar");
        saveAndCloseBtn().click();
    }

    public void clickHelpBtn() {
        Log4j.info("Step: Click on 'Help' icon of the top right toolbar");
        helpBtn().click();
    }

    public void clickSearchBtn() {
        Log4j.info("Step: Click on 'search' icon");
        searchBtn().click();
    }

    public void clickComponentsMenu() {
        Log4j.info("Step: Click on Components on Menu tab");
        componentsMenu().click();
    }

    public void clickBannersDrd() {
        Log4j.info("Step: Click on Banners dropdown on Menu tab");
        bannersDrd().click();
    }

    public void clickNewBtn() {
        Log4j.info("Step: Click on 'New' icon of the top right toolbar");
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

    public void selectCheckbox(String title) {
        if (checkBox(title).size() == 1) {
            DRIVER.findElement(
                    By.xpath(String.format(_checkBox, title))).click();
        }
    }

    public boolean doesElementStatus(String title, String status) {
        return DRIVER.findElements(
                By.xpath(String.format(_boxName, title, status))).size() == 1;

    }

    public void inputNameTxt(String name) {
        Log4j.info("Input Title name");
        clickWhenElementReady(nameTxt());
        nameTxt().sendKeys(name);
    }

    public void inputTitleTxt(String title) {
        Log4j.info("Input Title");
        titleTxt().sendKeys(title);
    }

    public void inputSearch(String text) {
        Log4j.info("Input in Search field");
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
    public String getAlertMessage() {
        waitUntilVisible(alertSuccessMessage());
        if (isElementPresented(alertSuccessMessage())) {
            return alertSuccessMessage().getText();
        } else return NO_MESSAGE_FOUND;

    }

    /**
     * Verify method
     */

    public Boolean doesHelpWindowDisplay() {
        return doesNewWindowDisplay(HELP_PAGE_TITLE);
    }
}
