package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log4j;

import static helper.DataHelper.*;
import static utils.Constants.*;

public class BannersPage extends BasePage {

    /**
     * This is place of Locator
     */

    private final By _bannersDrd = By.xpath("//li[@class='dropdown open']//li[@class='dropdown-submenu']/a[.='Banners']");
    private final By _newBtn = By.cssSelector(".button-new");
    private final By _nameTxt = By.cssSelector("#jform_name");
    private final By _bannerClients = By.xpath("//ul[@id='nav-empty']//a[.='Clients']");
    private final By _bannerCategories = By.xpath("//ul[@id='nav-empty']//a[.='Categories']");
    private final By _bannerQuantity = By.cssSelector("#list_limit_chzn > a");
    private final By _bannerQuantity20 = By.xpath("//li[.='20']");

    /**
     * This is place of Web Elements
     */

    private WebElement bannersDrd() {
        return DRIVER.findElement(_bannersDrd);
    }

    private WebElement newBtn() {
        return DRIVER.findElement(_newBtn);
    }

    private WebElement nameTxt() {
        return DRIVER.findElement(_nameTxt);
    }

    private WebElement bannerClients() {
        return DRIVER.findElement(_bannerClients);
    }

    private WebElement bannerCategories() {
        return DRIVER.findElement(_bannerCategories);
    }

    private WebElement bannerQuantity() {
        return DRIVER.findElement(_bannerQuantity);
    }

    private WebElement bannerQuantity20() {
        return DRIVER.findElement(_bannerQuantity20);
    }

    /**
     * This is place create methods
     */

    public void clickBannersDrd() {
        Log4j.info("Step: Click on Components on Menu tab");
        bannersDrd().click();
    }

    public void clickNewBtn() {
        Log4j.info("Step: Click on 'New' icon of the top right toolbar");
        newBtn().click();
    }

    public void clickBannerClients() {
        Log4j.info("Step: Select Components -> Banners -> Clients");
        bannerClients().click();
    }

    public void clickBannerCategories() {
        Log4j.info("Step: Select Components -> Banners -> Categories");
        bannerCategories().click();
    }

    public void clickBannerQuantity() {
        Log4j.info("Step: Select quantity that user wants to display");
        bannerQuantity().click();
    }

    public void clickBannerQuantity20() {
        Log4j.info("Step: Select quantity : 20");
        bannerQuantity20().click();
    }

    public void inputNameTxt(String name) {
        nameTxt().sendKeys(name);
    }


    public void navigateToBannersPage() {
        clickComponentsMenu();
        clickBannersDrd();
    }

    public void navigateToClientsPage() {
        clickComponentsMenu();
        clickBannerClients();
    }

    public void navigateToCategoriesPage() {
        clickComponentsMenu();
        clickBannerCategories();
    }

    public void createNewBanner() {
        navigateToBannersPage();
        clickNewBtn();
        inputNameTxt(randomBanner());
        clickSaveBtn();
    }

    public void createNewClient() {
        navigateToClientsPage();
        clickNewBtn();
        inputNameTxt(randomName());
        clickSaveBtn();
    }

    public void createCategories() {
        navigateToCategoriesPage();
        clickNewBtn();
        inputNameTxt(randomCategories());
        clickSaveBtn();
    }

    public void selectQuantity20() throws InterruptedException {
        navigateToBannersPage();
        clickBannerQuantity();
        clickBannerQuantity20();
    }

    /**
     * This is place create verify methods
     */
    public Boolean verifyUserChoose20() {
        navigateToBannersPage();
        return bannerQuantity().getText().equals("20");
    }

}