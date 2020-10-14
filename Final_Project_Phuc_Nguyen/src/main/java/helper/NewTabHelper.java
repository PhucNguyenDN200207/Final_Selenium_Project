package helper;

import java.util.ArrayList;

import static utils.Constants.*;

public class NewTabHelper {

    public static boolean verifyNewTabTitle(String title) throws InterruptedException {
        // Get all Open Tabs
        ArrayList<String> tabHandles = new ArrayList<String>(DRIVER.getWindowHandles());
        for (String eachHandle : tabHandles) {
            Thread.sleep(TIME_OUT_SHORT);
            DRIVER.switchTo().window(eachHandle);

            // Check Help Page Title
            if (DRIVER.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }
}
