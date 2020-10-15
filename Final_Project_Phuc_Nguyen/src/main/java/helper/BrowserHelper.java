package helper;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.object.*;
import utils.Constants;
import utils.Log4j;

import java.util.ArrayList;

import static utils.Constants.DRIVER;
import static utils.Constants.PAGE_LOAD_TIME_OUT;

public class BrowserHelper {
    ArticlePage articlePage = new ArticlePage();
    BannersBannersPage bannersBannersPage = new BannersBannersPage();
    BannersCategoriesPage bannersCategoriesPage = new BannersCategoriesPage();
    BannersClientsPage bannersClientsPage = new BannersClientsPage();
    ContactsPage contactsPage = new ContactsPage();

    public static void openChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        Constants.DRIVER = new ChromeDriver();
        Log4j.header("Browser: " + Constants.CHROME);
    }

    public static void openFirefoxBrowser() {
        WebDriverManager.firefoxdriver().setup();
        Constants.DRIVER = new FirefoxDriver();
        Log4j.header("Browser: " + Constants.FIREFOX);
    }

    public static void openEdgeBrowser() {
        WebDriverManager.edgedriver().setup();
        Constants.DRIVER = new EdgeDriver();
        Log4j.header("Browser: " + Constants.EDGE);
    }

    public static void navigate(String url) {
        Constants.DRIVER.get(url);
    }

    /**
     * Re-navigate to JOOMLA administrator main page then navigate to Article Manager
     * to verify new create Article
     */
    public void navigateToArticleManager() {
        navigate(Constants.JOOMLA_HOME_URL);
        articlePage.clickArticleManager();
        articlePage.chooseSortByIdDescending();
    }

    /**
     * Re-navigate to JOOMLA administrator main page then navigate to Banner Manager
     * to verify new create Banner
     */
    public void navigateToBannerManager() {
        navigate(Constants.JOOMLA_HOME_URL);
        bannersBannersPage.navigateToBannersPage();
        bannersBannersPage.chooseSortByIdDescending();
    }


    /**
     * Re-navigate to JOOMLA administrator main page then navigate to Categories Manager
     * to verify new create category
     */
    public void navigateToCategoriesManager() {
        BrowserHelper.navigate(Constants.JOOMLA_HOME_URL);
        bannersCategoriesPage.navigateToCategoriesPage();
        bannersCategoriesPage.chooseSortByIdDescending();
    }

    public void navigateToContactManagerPage() {
        Log4j.info("Navigate to Contact manager Page to verify new Contact");
        BrowserHelper.navigate(Constants.JOOMLA_HOME_URL);
        contactsPage.navigateToContactPage();
        contactsPage.chooseSortByIdDescending();
    }

    /**
     * Use for Help page
     *
     * @param title New web title after action click or open
     * @return true if it has two browser windows and the title of new window match
     */
    public static boolean doesNewWindowDisplay(String title) {
        // Get all Open Tabs
        ArrayList<String> tabHandles = new ArrayList<String>(DRIVER.getWindowHandles());
        // handel Firefox
        WebDriverWait wait = new WebDriverWait(DRIVER.switchTo().window(tabHandles.get(tabHandles.size() - 1)), PAGE_LOAD_TIME_OUT);
        wait.until(ExpectedConditions.titleContains(title));

        return tabHandles.size() == 2 &&
                DRIVER.switchTo().window(tabHandles.get(tabHandles.size() - 1)).getTitle().equals(title);
    }
}
