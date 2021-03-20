package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.helper.Reporter;
import test.java.helper.Ultilities;

import java.util.List;

public class ManagerHomePage extends BasePage{

    @FindBy(xpath = "//marquee[@behavior='alternate']")
    public WebElement welcomeToManagerPageMessage;

    @FindBy(xpath = "//img[contains(@srcset,'unsplash.com/photo')]")
    public WebElement firstImage;

    @FindBy(xpath = "//img[contains(@srcset,'unsplash.com/photo')]")
    public List<WebElement> listImage;

    @FindBy(xpath = "//button[@title='Like photo']")
    public List<WebElement> listLikePhotoButton;

    @FindBy(xpath = "//button[@title='Add to collection']")
    public List<WebElement> listAddToCollectionButton;

    @FindBy(xpath = "//a[@title='Download photo']")
    public List<WebElement> listDownloadImage;

    @FindBy(xpath = "//div[@data-test='photos-route']//a[@title='Download photo']")
    public WebElement downloadImageBtn;

    public void verifyHomePageDisplay(){
        verifyElementVisible(welcomeToManagerPageMessage);
        Reporter.captureScreenshot(Ultilities.getCurrentMethodName());
    }

}
