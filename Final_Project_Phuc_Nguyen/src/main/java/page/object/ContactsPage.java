package page.object;


import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.Log4j;

import static helper.DataHelper.*;
import static utils.Constants.*;

public class ContactsPage extends BasePage {

    /**
     * This is place of Locator
     */
    private final By _contactDrd = By.xpath("//li[@class='dropdown open']//li[@class='dropdown-submenu']/a[.='Contacts']");
    private final String _newContactTitle = "//a[.='%s']";

    /**
     * This is place of Web Elements
     */

    private WebElement contactDrd() {
        return DRIVER.findElement(_contactDrd);
    }

    private WebElement newContactTitle(String title) {
        return elementByText(_newContactTitle, title);
    }

    /**
     * This is place create methods
     */

    public void clickContactDrd() {
        Log4j.info("Step: Click on Components on Menu tab");
        contactDrd().click();
    }

    /**
     * This is place create verify methods
     */

    public void navigateToContactPage() {
        clickComponentsMenu();
        clickContactDrd();
    }

    public void openHelpPage() {
        navigateToContactPage();
        clickHelpBtn();
    }

    public void createNewContact(String name) {
        navigateToContactPage();
        clickNewBtn();

        Log4j.info("Create new contact: " + name);
        inputNameTxt(name);
        clickSaveBtn();
    }

    public void navigateToContactManagerPage() {
        Log4j.info("Navigate to Contact manager Page to verify new Contact");
        DriverHelper.navigate(Constants.JOOMLA_HOME_URL);
        navigateToContactPage();
        chooseSortByIdDescending();
    }

    public Boolean isNewContactDisplayed(String title) {
        return isElementPresented(newContactTitle(title));
    }
}
