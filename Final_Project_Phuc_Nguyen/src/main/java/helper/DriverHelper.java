package helper;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Constants;
import utils.Log4j;

public class DriverHelper {
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
}
