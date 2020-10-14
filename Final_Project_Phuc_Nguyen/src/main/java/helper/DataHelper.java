package helper;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Locale;

import static utils.Constants.*;

public class DataHelper {

    static Faker faker = new Faker(new Locale("en"));

    public static String randomName() {
        return faker.name().username();
    }

    public static String randomTitle() {
        return faker.book().title();
    }

    public static String randomBanner() {
        return faker.app().name();
    }

    public static String randomCategories() {
        return faker.educator().university();
    }

    public static String randomContent() {
        return faker.lorem().paragraph();
    }

    public static int randomNumber(int min, int max) {
        return faker.number().numberBetween(min, max);
    }


}
