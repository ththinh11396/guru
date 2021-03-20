package test.java.wrapper;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.java.common.Constant;
import test.java.driverFactory.DriverManager;
import test.java.helper.ConfigProperties;

import java.io.File;

public class WebElementWrapper {
    public void  click(WebElement webElement){
        try{
            waitForElementClickable(webElement);
            webElement.click();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForElementClickable(WebElement webElement){
        return waitForElementClickable(webElement,ConfigProperties.getWaitTimeout(),true);
    }

    public WebElement waitForElementClickable(WebElement webElement,long timeout,boolean throwException){
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), timeout);
        try{
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        }catch(StaleElementReferenceException staleException){
            webElement = recoverFromStaleElement(webElement);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        }catch (Exception exception){
            if(throwException)
                throw exception;
        }
        return webElement;
    }

    public WebElement waitForElementVisible (WebElement webElement) {
        return waitForElementVisible(webElement, ConfigProperties.getWaitTimeout(), true);
    }

    public WebElement waitForElementVisible(WebElement webElement,long timeout,boolean throwException){
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), timeout);
        try{
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        }catch(StaleElementReferenceException staleException){
            webElement = recoverFromStaleElement(webElement);
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        }catch (Exception exception){
            if(throwException)
                throw exception;
        }
        return webElement;
    }

    public WebElement waitForElementPresence (WebElement webElement) {
        return waitForElementPresence(webElement, ConfigProperties.getWaitTimeout(), true);
    }

    public WebElement waitForElementPresence(WebElement webElement,long timeout,boolean throwException){
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), timeout);
        try{
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getByFromElement(webElement)));
        }catch(StaleElementReferenceException staleException){
            webElement = recoverFromStaleElement(webElement);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getByFromElement(webElement)));
        }catch (Exception exception){
            if(throwException)
                throw exception;
        }
        return webElement;
    }

    public WebElement recoverFromStaleElement(WebElement webElement) {
        System.out.println("Stale element found(" + webElement + " Recovering...");

        String addressAndLocator = webElement.toString().split("-> ")[1];
        String[] temp = addressAndLocator.split(": ");
        String locator = temp[0];
        String address = temp[1].substring(0, temp[1].length() - 1);

        switch (locator) {
            case "id":
                webElement = DriverManager.getDriver().findElement(By.id(address));
                break;
            case "xpath":
                webElement = DriverManager.getDriver()
                        .findElement(By.xpath(address));
                break;
            case "css selector":
                webElement = DriverManager.getDriver()
                        .findElement(By.cssSelector(address));
                break;
            case "name":
                webElement = DriverManager.getDriver()
                        .findElement(By.name(address));
                break;
            default:
                System.out.println("WebElement Issue");
        }

        return webElement;
    }

    public void setText(WebElement webElement,String text,boolean isClear){
        try {
            waitForElementVisible(webElement);
            if(isClear)
                webElement.clear();
            webElement.sendKeys((CharSequence)text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public By getByFromElement(WebElement webElement) {
        By by = null;
        String addressAndLocator = webElement.toString().split("-> ")[1];
        String[] temp = addressAndLocator.split(": ");
        String locator = temp[0];
        String address = temp[1].substring(0, temp[1].length() - 1);

        switch (locator) {
            case "id":
                by = By.id(address);
                break;
            case "class name":
                by = By.className(address);
                break;
            case "xpath":
                by = By.xpath(address);
                break;
            case "css selector":
                by = By.cssSelector(address);
                break;
            case "name":
                by = By.name(address);
                break;
            case "linkText":
                by = By.linkText(address);
                break;
            case "partialLinkText":
                by = By.partialLinkText(address);
                break;
            default:
                System.out.println("Locator "+ locator + " not found");
        }
        return by;
    }

    public void setTextWithoutClear(WebElement webElement,String text){
        setText(webElement,text,false);
    }

    public void setText(WebElement webElement,String text){
        setText(webElement,text,true);
    }

    public WebElement getElementContainsText(String text){
        return DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'"+text+"')]"));
    }

    public void scrollToElement(WebElement webElement){
        waitForElementPresence(webElement);
        try {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isVisible(WebElement webElement){
        boolean visible;
        try{
            waitForElementVisible(webElement);
            visible = true;
        }catch (Exception e){
            visible = false;
        }
        return visible;
    }

    public boolean isVisible(WebElement webElement,long timeout){
        boolean visible;
        try{
            waitForElementVisible(webElement,timeout,true);
            visible = true;
        }catch (Exception e){
            visible = false;
        }
        return visible;
    }

    public void verifyElementVisible(WebElement webElement){
        boolean visible = isVisible(webElement);
        Assert.assertTrue(visible);
    }

    public void assertEquals(Object currentValue,Object expectedValue){
        Assert.assertEquals(currentValue,expectedValue);
    }

    public void setTextAction(WebElement webElement,String string){
        Actions actions = new Actions(DriverManager.getDriver());
        actions.sendKeys(webElement,string);
    }

    public void setTextAction(CharSequence charSequence){
        Actions actions = new Actions(DriverManager.getDriver());
        actions.sendKeys(charSequence).build().perform();
    }

    public void staticWait(long seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
    }

    public void hover(WebElement webElement,long staticWait){
        Actions actions = new Actions(DriverManager.getDriver());
        waitForElementVisible(webElement);
        actions.moveToElement(webElement).perform();
    }
    public void hover(WebElement webElement){
        hover(webElement,ConfigProperties.getWaitShortTime());
    }

    public String getAttribute(WebElement webElement,String attribute){
        waitForElementPresence(webElement);
        return webElement.getAttribute(attribute);
    }

    public String getAttributeClass(WebElement webElement){
        return webElement.getAttribute("class");
    }
    public String getAttributeValue(WebElement webElement){
        return webElement.getAttribute("value");
    }
    public String getText(WebElement webElement,long timeout){
        waitForElementPresence(webElement,timeout,true);
        return webElement.getText();
    }
    public String getText(WebElement webElement){
        return getText(webElement,ConfigProperties.getWaitLongTime());
    }

    public void back(){
        DriverManager.getDriver().navigate().back();
    }
    public File getLatestFileFromDir() {
        File dir = new File(Constant.DOWNLOADS_FOLDER_PATH);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }
    public String getCurrentURL(){
        return DriverManager.getDriver().getCurrentUrl();
    }

    public void selectOptionByValue(WebElement webElement,String value){
        Select select = new Select(webElement);
        select.selectByValue(value);
    }
}
