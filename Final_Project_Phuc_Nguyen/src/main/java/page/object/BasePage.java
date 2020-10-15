package page.object;

import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;
import utils.Log4j;

import static helper.NewTabHelper.verifyNewTabTitle;
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
    private final By _nameTxt = By.cssSelector("#jform_name");
    private final By _titleTxt = By.cssSelector("#jform_title");
    private final By _searchTxt = By.cssSelector("#filter_search");
    private final By _sortByDrd = By.xpath("//*[@id='list_fullordering_chzn']/a");
    private final By _sortByIdDescending = By.xpath("//li[.='ID descending']");

    /**
     * This is place create common Web elements
     */

    private WebElement saveBtn() {
        return DRIVER.findElement(_saveBtn);
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


    private WebElement sortByDrd() {
        return DRIVER.findElement(_sortByDrd);
    }

    private WebElement sortByIdDescending() {
        return DRIVER.findElement(_sortByIdDescending);
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
     * Common method
     */

    public void clickSaveBtn() {
        Log4j.info("Step: Click on 'Save & Close' icon of the top right toolbar");
        saveBtn().click();
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

    public void chooseSortByIdDescending() {
        clickSortByDrd();
        clickSortByIdDescending();
    }


    public void navigateToBannersPage() {
        clickComponentsMenu();
        clickBannersDrd();
    }

    /**
     * Verify method
     */

    public String getAlertMessage() {
        if (isElementPresented(alertSuccessMessage())) {
            return alertSuccessMessage().getText();
        } else return NO_MESSAGE_FOUND;

    }

    public Boolean verifyHelpPageTitle() throws InterruptedException {
        return verifyNewTabTitle(HELP_PAGE_TITLE);
    }
}
