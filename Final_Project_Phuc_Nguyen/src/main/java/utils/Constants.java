package utils;

import org.openqa.selenium.WebDriver;

public class Constants {
    public static WebDriver DRIVER;

    public static final String JOOMLA_HOME_URL = "http://13.82.211.128:8080/administrator";
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String EDGE = "edge";
    public static final String USER_NAME = "phuc";
    public static final String PASSWORD = "phuc123";
    public static final String AUTHOR = "Phuc";
    public static final String ARTICLE_ALERT_MESSAGE = "Article saved.";
    public static final String DEFAULT_ARTICLE_CATEGORY = "Sample Data-Articles";
    public static final String HELP_PAGE_TITLE = "Joomla! Help Screens";
    public static final String CONTACT_SUCCESS_MESSAGE = "Contact saved.";
    public static final String BANNERS_SUCCESS_MESSAGE = "Banner saved.";
    public static final String CLIENTS_SUCCESS_MESSAGE = "Client saved.";
    public static final String CATEGORIES_SUCCESS_MESSAGE = "Category saved.";
    public static final String ARTICLE_UNPUBLISHED_MESSAGE = "1 article unpublished.";
    public static final String CLIENT_UNPUBLISHED_MESSAGE = "1 client unpublished.";
    public static final String ELEMENT_MESSAGE_NOT_FOUND = "ELEMENT_MESSAGE_NOT_FOUND";
    public static final int PAGE_LOAD_TIME_OUT = 5;
    public static final int EXPLICIT_WAIT = 15;

}
