package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log4j;

import static helper.DataHelper.*;
import static utils.Constants.*;

public class BannersBannersPage extends BasePage {

    /**
     * This is place of Locator
     */

    private final By _bannerCategories = By.xpath("//*[@id='submenu']/li/a[.='Categories']");
    private final By _bannerQuantity = By.cssSelector("#list_limit_chzn > a");
    private final By _bannerQuantity20 = By.xpath("//li[.='20']");

    /**
     * This is place of Web Elements
     */

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

    public void clickBannerCategories() {
        Log4j.info("Step: Click on Categories");
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

    public void navigateToBannersPage() {
        clickComponentsMenu();
        clickBannersDrd();
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

    public void createCategories() {
        navigateToCategoriesPage();
        clickNewBtn();
        inputNameTxt(randomCategories());
        clickSaveBtn();
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

}