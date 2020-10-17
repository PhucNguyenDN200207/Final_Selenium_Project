package page.object;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        contactDrd().click();
    }

    /**
     * Create new contract
     * @param name random contract name
     */
    public void enterNewContact(String name) {
        enterNameTxt(name);
    }

    /**
     * This is place create verify methods
     */

    public Boolean isNewContactDisplayed(String title) {
        return isElementPresented(newContactTitle(title));
    }
}
