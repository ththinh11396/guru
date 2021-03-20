package test.java.helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import test.java.driverFactory.DriverManager;

import java.io.File;
import java.io.IOException;

public class Reporter {
    static ExtentReports extentReports;
    static ExtentTest extentTest;
    static ExtentTest extentNode;
    static ExtentTest extentScenario;

    public static void createReporter(String browser){
        ExtentSparkReporter spark = new ExtentSparkReporter(Ultilities.getReportPath()+"extent-report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(spark);
        extentReports.setSystemInfo("Browser",browser);
    }
    public static void createTest(String testName){
        extentTest = extentReports.createTest(testName);
    }

    public static void createNote(String testNode){
        extentNode = extentScenario.createNode(testNode).pass("pass");
    }
    public static void createScenarioNote(String testScenarioNode) {
        extentScenario = extentTest.createNode(Scenario.class, testScenarioNode);
    }

    public static void createFailNote(String failNode){
        extentNode = extentScenario.createNode(failNode).fail("fail");
        captureScreenshot("Exception");
        Assert.fail(failNode);
    }

    public static void flush(){
        extentReports.flush();
    }

    public static void captureScreenshot(String fileName){
        fileName = Ultilities.removeSpecialCharacter(fileName)+Ultilities.getCurrentTime()+ ".png";
        String destScreenshotPath = Ultilities.getScreenshotsPath() + fileName;
        String imgReportSrc = "screenshots"+File.separator + fileName;

        File srcScreenshotFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        File destScreenshotFile = new File(destScreenshotPath);
        try {
            FileUtils.copyFile(srcScreenshotFile, destScreenshotFile);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        extentNode.log(Status.INFO,"Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(imgReportSrc).build());
    }
}
