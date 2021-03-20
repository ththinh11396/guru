package test.java.common;

import test.java.helper.Ultilities;

import java.io.File;

public class Constant {
    public static final String CHROME_DRIVER_PATH = Ultilities.getProjectPath()
            + "/src/test/resources/driver/chromedriver.exe";
    public static final String FIREFOX_DRIVER_PATH = Ultilities.getProjectPath()
            + "/src/test/resources/driver/geckodriver.exe";
    public static final String CONFIG_PROPERTIES_PATH = Ultilities.getProjectPath()
            + "/src/test/resources/config/config.properties";
    public static final String USER_HOME = System.getProperty("user.home");
    public static final String DOWNLOADS_FOLDER_PATH = USER_HOME + File.separator + "Downloads";
    public static final String LOG4J_PATH = Ultilities.getProjectPath() + "/src/test/resources/config/log4j.xml";
    public static final String LOG4J_LOG_FILE = Ultilities.getProjectPath() + "/src/test/resources/logs/log.txt";
    public static final String ACCOUNT_TYPE_SAVINGS = "Savings";
    public static final String ACCOUNT_TYPE_CURRENT = "Current";

}
