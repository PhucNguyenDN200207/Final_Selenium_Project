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
    private final By _componentsMenu = By.xpath("//*[@id='menu']/li//a[contains(.,'Components')]");
    private final By _contactDrd = By.xpath("//li[@class='dropdown open']//li[@class='dropdown-submenu']/a[.='Contacts']");
    private final By _newBtn = By.cssSelector(".button-new");
    private final By _contactName = By.cssSelector("#jform_name");
    private final By _contactAlias = By.cssSelector("#jform_alias");

    /**
     * This is place of Web Elements
     */
    private WebElement componentsMenu() {
        return DRIVER.findElement(_componentsMenu);
    }

    private WebElement contactDrd() {
        return DRIVER.findElement(_contactDrd);
    }

    private WebElement newBtn() {
        return DRIVER.findElement(_newBtn);
    }

    private WebElement contactName() {
        return DRIVER.findElement(_contactName);
    }

    private WebElement contactAlias() {
        return DRIVER.findElement(_contactAlias);
    }

    /**
     * This is place create methods
     */
    public void clickComponentsMenu() {
        Log4j.info("Step: Click on Components on Menu tab");
        componentsMenu().click();
    }

    public void clickContactDrd() {
        Log4j.info("Step: Click on Components on Menu tab");
        contactDrd().click();
    }

    public void clickNewBtn() {
        Log4j.info("Step: Click on 'New' icon of the top right toolbar");
        newBtn().click();
    }

    public void inputContactName(String name) {
        contactName().sendKeys(name);
    }

    public void inputContactAlias(String alias) {
        contactAlias().sendKeys(alias);
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
        inputContactName(randomName());
        clickSaveBtn();
    }


}
