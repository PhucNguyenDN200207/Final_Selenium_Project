package page.object;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log4j;

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

    }

    public void openHelpPage() {
        navigateToContactPage();
        clickHelpBtn();
    }

    /**
     * Create new contract
     * @param name random contract name
     */
    public void createNewContact(String name) {
        Log4j.info("Create new contact: " + name);
        inputNameTxt(name);
    }

    public Boolean isNewContactDisplayed(String title) {
        return isElementPresented(newContactTitle(title));
    }
}
