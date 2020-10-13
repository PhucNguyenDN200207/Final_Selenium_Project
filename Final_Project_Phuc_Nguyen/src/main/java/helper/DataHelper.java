package helper;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {

    static Faker faker = new Faker(new Locale("en"));

    public static String randomValidUsername() {
        return faker.lorem().characters(
                1, 32 - 9, true, true)
                + "@mail.com";
    }

    public static int randomValidPid() {
        return randomNumber(100000000, 999999999);
    }

    public static int randomNumber(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

}
