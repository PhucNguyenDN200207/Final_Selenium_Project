package page.object;

import helper.BrowserHelper;
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

    /**
     * Re-navigate to JOOMLA administrator main page then navigate to Categories Manager
     * to verify new create category
     */
    public void navigateToCategoriesManager() {
        BrowserHelper.navigate(Constants.JOOMLA_HOME_URL);
        navigateToCategoriesPage();
        chooseSortByIdDescending();
    }

    /**
     * Create new Category for Banner
     * @param title random category title
     * TODO function fail when create random data with special characters.
     */
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