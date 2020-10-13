package utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4j {

    public static Logger logger = LogManager.getLogger("Test");

    public Log4j() {
        DOMConfigurator.configure("log4j.xml");
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void header(String str) {
        info("<--------------------" + str + "-------------------->\n");
    }
}
