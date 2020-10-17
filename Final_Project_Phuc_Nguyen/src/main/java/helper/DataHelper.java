package helper;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {

    static Faker faker = new Faker(new Locale("en"));

    public static String randomName() {
        return faker.letterify("????????");
    }

    public static String randomEmail() {
        return randomName() + faker.internet().safeEmailAddress().trim();
    }

    public static String randomTitle() {
        return faker.letterify("??????????", true);
    }

    public static String randomBanner() {
        return faker.letterify("??????????", true);
    }

    public static String randomCategories() {
        return faker.letterify("???????????", true);
    }

    public static String randomContent() {
        return faker.lorem().paragraph(randomNumber(1, 99));
    }

    public static int randomNumber(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

}
