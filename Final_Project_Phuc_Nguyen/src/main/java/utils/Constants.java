package utils;

import org.openqa.selenium.WebDriver;

import java.security.PublicKey;

public class Constants {
    public static WebDriver DRIVER;

    public static final String JOOMLA_HOME_URL = "http://13.82.211.128:8080/administrator";
    public static final String JOOMLA_ARTICLE_MANAGER_URL = "http://13.82.211.128:8080/administrator/index.php?option=com_content";
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String EDGE = "edge";
    public static final String USER_NAME = "phuc";
    public static final String PASSWORD = "phuc123";
    public static final String AUTHOR = "Phuc";
    public static final String ARTICLE_TITLE = "Test Article 1";
    public static final String SAMPLE_DATA_ARTICLES = "Sample Data-Articles";
    public static final String ARTICLE_CONTENT_TEXT = " This is article content";
    public static final String ARTICLE_ALERT_MESSAGE = "Article successfully saved";
    public static final String HELP_PAGE_TITLE = "Joomla! Help Screens";
    public static final String CONTACT_SUCCESS_MESSAGE = "Contact successfully saved";
    public static final String BANNERS_SUCCESS_MESSAGE = "Banner successfully saved";
    public static final String CLIENTS_SUCCESS_MESSAGE = "Client successfully saved";
    public static final String CATEGORIES_SUCCESS_MESSAGE = "Category successfully saved";
    public static final String NO_MESSAGE_FOUND = "NO MESSAGE FOUND";
    public static final int PAGE_LOAD_TIME_OUT = 3;
    public static final int IMPLICIT_WAIT = 15;
    public static final int EXPLICIT_WAIT = 15;

}
