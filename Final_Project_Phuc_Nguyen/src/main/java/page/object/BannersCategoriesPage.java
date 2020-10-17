package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.Constants.*;

public class BannersCategoriesPage extends BasePage {

    /**
     * This is place of Locator
     */

    private final By _bannerCategories = By.xpath("//*[@id='submenu']/li/a[.='Categories']");
    private final String _newCateGoryTitle = "//td//a[normalize-space(text())='%s']";

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
        bannerCategories().click();
    }

    /**
     * Create new Category for Banner
     * @param title random category title
     */
    public void createCategories(String title) {
        enterTitleTxt(title);
    }

    /**
     * This is place create verify methods
     */
    public Boolean isNewCateGoryTitleDisplayed(String title) {
        return isElementPresented(newCateGoryTitle(title));
    }

}