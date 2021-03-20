package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBarPage extends BasePage{
    @FindBy(xpath = "//a[@href='addcustomerpage.php']")
    public WebElement newCustomerMenu;

    @FindBy(xpath = "//a[@href='addAccount.php']")
    public WebElement newAccountMenu;

    @FindBy(xpath = "//a[@href='DepositInput.php']")
    public WebElement depositMenu;

    public void clickNewCustomerMenu(){
        click(newCustomerMenu);
    }

    public void clickNewAccountMenu(){
        click(newAccountMenu);
    }
    public void clickDepositMenu(){
        click(depositMenu);
    }
}
