package helper;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {

    static Faker faker = new Faker(new Locale("en"));

    public static String randomName() {
        return faker.name().fullName();
    }

    public static String randomEmail() {
        return faker.internet().safeEmailAddress().trim();
    }

    public static String randomTitle() {
        return faker.name().username().trim();
    }

    public static String randomBanner() {
        return faker.name().nameWithMiddle().trim();
    }

    public static String randomCategories() {
        return faker.educator().course().trim();
    }

    public static String randomContent() {
        return faker.lorem().paragraph().trim();
    }

}
