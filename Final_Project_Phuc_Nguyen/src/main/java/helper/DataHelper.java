package helper;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {

    static Faker faker = new Faker(new Locale("en"));

    public static String randomName() {
        return faker.name().fullName();
    }

    public static String randomEmail() {
        return faker.internet().safeEmailAddress();
    }

    public static String randomTitle() {
        return faker.company().name();
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
