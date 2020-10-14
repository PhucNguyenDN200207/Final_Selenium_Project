package page.object;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log4j;

import static helper.DataHelper.*;
import static utils.Constants.*;

public class ContactsPage extends BasePage {
    /**
     * This is place of Locator
     */
    private final By _contactDrd = By.xpath("//li[@class='dropdown open']//li[@class='dropdown-submenu']/a[.='Contacts']");
    private final By _contactAlias = By.cssSelector("#jform_alias");

    /**
     * This is place of Web Elements
     */

    private WebElement contactDrd() {
        return DRIVER.findElement(_contactDrd);
    }

    private WebElement contactAlias() {
        return DRIVER.findElement(_contactAlias);
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

    public void createNewContact() {
        navigateToContactPage();
        clickNewBtn();
        inputNameTxt(randomName());
        clickSaveBtn();
    }

}
