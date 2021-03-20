package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import test.java.driverFactory.DriverManager;
import test.java.helper.ConfigProperties;
import test.java.helper.Reporter;
import test.java.helper.Ultilities;
import test.java.wrapper.WebElementWrapper;

import java.util.List;

public class BasePage extends WebElementWrapper {
    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public void checkPageIsReady() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            return;
        }
        for (int i = 0; i < ConfigProperties.getWaitTimeout(); i++) {
            try {
                staticWait(1);
            } catch (InterruptedException ignored) {
            }
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

    public void goToBaseURL(){
        goToURL(ConfigProperties.getURL());
    }
    public void goToURL(String url){
        DriverManager.getDriver().navigate().to(url);
    }
    public void verifyDownloadedFileName(String fileName){
        Assert.assertTrue(getLatestFileFromDir().getName().contains(fileName));
        Reporter.captureScreenshot(Ultilities.getCurrentMethodName());
    }
}
