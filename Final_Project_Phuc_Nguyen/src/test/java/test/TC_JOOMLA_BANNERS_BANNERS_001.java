package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.BannersBannersPage;
import page.object.BannersCategoriesPage;
import page.object.BannersClientsPage;
import utils.Log4j;

import static helper.DataHelper.*;

public class TC_JOOMLA_BANNERS_BANNERS_001 extends BaseTest {
    BannersBannersPage bannersBannersPage = new BannersBannersPage();
    BannersClientsPage bannersClientsPage = new BannersClientsPage();
    BannersCategoriesPage bannersCategoriesPage = new BannersCategoriesPage();

    @Test(description = "User can create new banner with valid information")
    public void testcase001() {
        Log4j.header("TC_JOOMLA_BANNERS_BANNERS_001");

        String clientTitle = randomTitle();
        String clientName = randomName();
        String clientEmail = randomEmail();

        // Verify point 1: TO_JOOMLA_BANNERS_CLIENTS_001
        bannersClientsPage.navigateToClientsPage();
        bannersClientsPage.clickNewBtn();
        bannersClientsPage.createNewClient(clientTitle, clientName, clientEmail);
        bannersClientsPage.clickSaveBtn();

//        Assert.assertEquals(bannersClientsPage.getAlertMessage(), CLIENTS_SUCCESS_MESSAGE,
//                "New Client Alert message failed");

        bannersClientsPage.navigateToClientManager();

        Assert.assertTrue(bannersClientsPage.isNewClientTitleDisplayed(clientTitle),
                "Create new client title failed");

        // Verify point 2: TO_JOOMLA_CATEGORY_MANAGER_001

        String categoryTitle = randomCategories();

        bannersCategoriesPage.createCategories(categoryTitle);

//        Assert.assertEquals(bannersCategoriesPage.getAlertMessage(), CATEGORIES_SUCCESS_MESSAGE,
//                "New Client Alert message failed");

        bannersCategoriesPage.navigateToCategoriesManager();

        Assert.assertTrue(bannersCategoriesPage.isNewCateGoryTitleDisplayed(categoryTitle),
                "Create new category title failed");

        // Verify point 3: TO_JOOMLA_BANNERS_BANNERS_001

        String bannerName = randomBanner();

        bannersBannersPage.createNewBanner(bannerName, categoryTitle, clientTitle);

//        Assert.assertEquals(bannersBannersPage.getAlertMessage(), BANNERS_SUCCESS_MESSAGE,
//                "New Banner Alert message failed");

        bannersBannersPage.navigateToBannerManager();

        Assert.assertTrue(bannersBannersPage.isNewBannerDisplayed(bannerName),
                "Create new banner title failed");

    }
}
