package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.BannersBannersPage;
import page.object.BannersCategoriesPage;
import page.object.BannersClientsPage;
import page.object.LoginPage;
import utils.Log4j;

import static helper.DataHelper.*;
import static utils.Constants.*;

public class TC_JOOMLA_BANNERS_BANNERS_008 extends BaseTest {
    BannersBannersPage bannersBannersPage = new BannersBannersPage();
    BannersClientsPage bannersClientsPage = new BannersClientsPage();
    BannersCategoriesPage bannersCategoriesPage = new BannersCategoriesPage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void login() {
        loginPage.login(USER_NAME, PASSWORD);

    }

    @Test(description = "Verify that user can search a banner by using filter textbox")
    public void testcase008() {
        Log4j.header("TC_JOOMLA_BANNERS_BANNERS_008");


        String clientTitle = randomTitle();
        String clientName = randomName();
        String clientEmail = randomEmail();

        //Verify point 1: TO_JOOMLA_BANNERS_CLIENTS_001
        Log4j.info("Step: Select Components -> Banners -> Clients");
        bannersClientsPage.clickComponentsMenu();

        bannersClientsPage.clickBannersOpt();

        bannersClientsPage.clickBannerClients();

        Log4j.info("Step: Click 'New' button in the right top corner");
        bannersClientsPage.clickNewBtn();

        Log4j.info("Step:Enter valid Client Name to Client Name textbox");
        Log4j.info("Step:Enter valid Contact Name to Contact Name textbox");
        Log4j.info("Step:Enter valid Contact Email to Contact Email textbox");
        bannersClientsPage.enterNewClient(clientTitle, clientName, clientEmail);

        Log4j.info("Step: Click 'Save & Close' button");
        bannersClientsPage.clickSaveAndCloseBtn();

        Log4j.info("Verify: A message : 'Client successfully saved' shows.");
        Assert.assertEquals(bannersClientsPage.getMessage(), CLIENTS_SUCCESS_MESSAGE,
                "New Client Alert message failed");

        bannersClientsPage.chooseSortByIdDescending();

        Log4j.info("Verify: New client is created");
        Assert.assertTrue(bannersClientsPage.isNewClientTitleDisplayed(clientTitle),
                "Create new client title failed");

        // Verify point 2: TO_JOOMLA_CATEGORY_MANAGER_001

        String categoryTitle = randomCategories();

        Log4j.info("Step: Select Components -> Banners -> Categories");
        bannersClientsPage.clickComponentsMenu();

        bannersClientsPage.clickBannersOpt();

        bannersCategoriesPage.clickBannerCategories();

        Log4j.info("Step: Click 'New' button in the right top corner");
        bannersCategoriesPage.clickNewBtn();

        Log4j.info("Step: Enter valid Category Name to Name text box");
        bannersCategoriesPage.createCategories(categoryTitle);

        Log4j.info("Step: Click 'Save & Close' button");
        bannersClientsPage.clickSaveAndCloseBtn();

        Log4j.info("Verify: A message : 'Category successfully saved' shows.");
        Assert.assertEquals(bannersCategoriesPage.getMessage(), CATEGORIES_SUCCESS_MESSAGE,
                "New Client Alert message failed");

        bannersCategoriesPage.chooseSortByIdDescending();

        Log4j.info("Verify: New Category is created");
        Assert.assertTrue(bannersCategoriesPage.isNewCateGoryTitleDisplayed(categoryTitle),
                "Create new category title failed");

        // Verify point 3: TO_JOOMLA_BANNERS_BANNERS_001

        String bannerName = randomBanner();

        Log4j.info("Step: Select Components -> Banners -> Banners");
        bannersBannersPage.clickComponentsMenu();

        bannersBannersPage.clickBannersOpt();

        Log4j.info("Click 'New' button in the right top corner");
        bannersBannersPage.clickNewBtn();

        Log4j.info("Step: Enter valid Name to Name text box");
        Log4j.info("Step: Select a Category in Category dropdown list");
        Log4j.info("Step: Select a Client in Client dropdown list");
        bannersBannersPage.createNewBanner(bannerName, categoryTitle, clientTitle);

        Log4j.info("Click 'Save & Close' button");
        bannersClientsPage.clickSaveAndCloseBtn();

        Log4j.info("Verify: A message : 'Banners successfully saved' shows.");
        Assert.assertEquals(bannersBannersPage.getMessage(), BANNERS_SUCCESS_MESSAGE,
                "New Banner Alert message failed");

        bannersBannersPage.chooseSortByIdDescending();

        Log4j.info("Verify: New Banner is created");
        Assert.assertTrue(bannersBannersPage.isNewBannerDisplayed(bannerName),
                "Create new banner title failed");

        // Verify point 4: TO_JOOMLA_BANNERS_BANNERS_008

        Log4j.info("Step: Enter valid Banner Name to Filter text box");
        bannersBannersPage.enterSearch(bannerName);

        Log4j.info("Step: Click 'Search' button");
        bannersBannersPage.clickSearchBtn();

        Log4j.info("Verify: Recently created banner displays in table");
        Assert.assertTrue(bannersBannersPage.isNewBannerDisplayed(bannerName),
                "Search new banner title failed");
    }
}
