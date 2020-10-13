package helper;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {

    static Faker faker = new Faker(new Locale("en"));


    public static int randomNumber(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

}
