package helper;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;
import utils.Log4j;

import java.util.ArrayList;

import static utils.Constants.*;

public class BrowserHelper {

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
     * Use for Help page
     *
     * @param title New web title after action click or open
     * @return true if it has two browser windows and the title of new window match
     */
    public static boolean doesNewWindowDisplay(String title, int numberWindow) {
        // Get all Open Tabs
        ArrayList<String> tabHandles = new ArrayList<String>(DRIVER.getWindowHandles());
        // handle Firefox
        WebDriverWait wait = new WebDriverWait(DRIVER.switchTo().window(tabHandles.get(tabHandles.size() - 1)), PAGE_LOAD_TIME_OUT);
        wait.until(ExpectedConditions.titleContains(title));

        return tabHandles.size() == numberWindow &&
                DRIVER.switchTo().window(tabHandles.get(tabHandles.size() - 1)).getTitle().equals(title);
    }
}
