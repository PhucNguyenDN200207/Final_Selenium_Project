package helper;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.object.BasePage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static utils.Constants.*;

public class NewWindowHelper {

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
