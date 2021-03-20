package test.java.driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import test.java.common.Constant;
import test.java.helper.ConfigProperties;
import test.java.helper.Reporter;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;

    public static void initWebDriver(String browser){
        if(browser.toLowerCase().equals("chrome"))
            initChromeDriver();
        else if(browser.toLowerCase().equals("firefox"))
            initFirefoxDriver();
        driver.manage().timeouts().implicitlyWait(ConfigProperties.getWaitShortTime(), TimeUnit.SECONDS);
    }

    private static void initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars", "--incognito", "--start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
    private static void initFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver", Constant.FIREFOX_DRIVER_PATH);
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-incognito", "-start-maximized");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void close(){
        getDriver().close();
    }

    public static void quit(){
        getDriver().quit();
    }

    public static void closeBrowser(){
        Reporter.flush();
        close();
        quit();
    }
}
