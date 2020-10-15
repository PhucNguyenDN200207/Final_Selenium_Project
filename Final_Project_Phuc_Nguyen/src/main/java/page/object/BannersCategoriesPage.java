package page.object;

import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.Log4j;

import static utils.Constants.*;

public class BannersCategoriesPage extends BasePage {

    /**
     * This is place of Locator
     */

    private final By _bannerCategories = By.xpath("//*[@id='submenu']/li/a[.='Categories']");
    private final String _newCateGoryTitle = "//a[contains(.,'%s')]";

    /**
     * This is place of Web Elements
     */

    private WebElement bannerCategories() {
        return DRIVER.findElement(_bannerCategories);
    }

    private WebElement newCateGoryTitle(String title) {
        return elementByText(_newCateGoryTitle, title);
    }


    /**
     * This is place create methods
     */

    public void clickBannerCategories() {
        Log4j.info("Step: Click on Categories");
        bannerCategories().click();
    }

    public void navigateToCategoriesPage() {
        clickComponentsMenu();
        clickBannersDrd();
        clickBannerCategories();
    }

    public void navigateToClientManager() {
        DriverHelper.navigate(Constants.JOOMLA_HOME_URL);
        navigateToCategoriesPage();
        chooseSortByIdDescending();
    }

    public void createCategories(String title) {
        navigateToCategoriesPage();
        clickNewBtn();
        inputTitleTxt(title);
        clickSaveBtn();
    }


    /**
     * This is place create verify methods
     */
    public Boolean isNewCateGoryTitleDisplayed(String title) {
        return isElementPresented(newCateGoryTitle(title));
    }

}