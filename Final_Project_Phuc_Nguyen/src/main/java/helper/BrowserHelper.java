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
    BannersClientsPage bannersClientsPage = new BannersClientsPage();

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
    }

    public void navigateToClientsPage() {
        bannersClientsPage.clickComponentsMenu();
        bannersClientsPage.clickBannersDrd();
        bannersClientsPage.clickBannerClients();
    }

    /**
     * Re-navigate to JOOMLA administrator main page then navigate to Client Manager
     * to verify new create Client
     */
    public void navigateToClientManager() {
        navigate(Constants.JOOMLA_HOME_URL);
        navigateToClientsPage();
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
