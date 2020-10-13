package helper;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Locale;

import static utils.Constants.*;

public class DataHelper {

    static Faker faker = new Faker(new Locale("en"));


    public static int randomNumber(int min, int max) {
        return faker.number().numberBetween(min, max);
    }
    public static boolean verifyHelpPageTitle() throws InterruptedException {
        Thread.sleep(TIME_OUT_SHORT);

        // Get all Open Tabs
        ArrayList<String> tabHandles = new ArrayList<String>(DRIVER.getWindowHandles());
        for (String eachHandle : tabHandles) {
            DRIVER.switchTo().window(eachHandle);

            // Check Help Page Title
            if (DRIVER.getTitle().equalsIgnoreCase(HELP_PAGE_TITLE)) {
                return true;
            }
        }
        return false;
    }
}
