package test.java.test;

import org.testng.annotations.*;
import test.java.common.Constant;
import test.java.driverFactory.DriverManager;
import test.java.helper.Logger;
import test.java.helper.Reporter;

import java.io.File;
import java.lang.reflect.Method;

public class BaseTest {
    static String browser="";
    Logger logger = new Logger(BaseTest.class);

    @Parameters("browser")
    @BeforeSuite
    public void beforeSuite(@Optional("chrome") String browser){
        logger.info("--------Start Suite----------");
        this.browser = browser;
        Reporter.createReporter(browser);
        File file = new File(Constant.LOG4J_LOG_FILE);
        if(file.exists()) {
            file.deleteOnExit();
        }
    }

    @BeforeMethod
    public void beforeMethod(Method caller){
        String testDescription = caller.getAnnotation(Test.class).description();
        String testCaseName = caller.getAnnotation(Test.class).testName();
        logger.info("Start Test Case: " + testCaseName);
        Reporter.createTest(testCaseName);
        DriverManager.initWebDriver(browser);

    }

    @AfterMethod
    public void afterMethod(Method caller){
        String testCaseName = caller.getAnnotation(Test.class).testName();
        logger.info("End Test Case: " + testCaseName);
        DriverManager.closeBrowser();
    }
}
