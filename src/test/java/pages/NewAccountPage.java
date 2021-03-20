package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.data.AccountEntity;
import test.java.helper.Reporter;
import test.java.helper.Ultilities;

public class NewAccountPage extends BasePage{
    @FindBy(xpath = "//input[@name='cusid']")
    public WebElement customerIDInput;

    @FindBy(xpath = "//select[@name='selaccount']")
    public WebElement accountTypeSelect;

    @FindBy(xpath = "//input[@name='inideposit']")
    public WebElement initialDepositInput;

    @FindBy(xpath = "//input[@name='button2']")
    public WebElement submitButton;

    @FindBy(xpath = "//td[text()='Account ID']/following-sibling::td")
    public WebElement accountId;

    public void setCustomerIDInput(String customerIDInput) {
        setText(this.customerIDInput,customerIDInput);
    }

    public void selectAccountType(String accountType) {
        selectOptionByValue(accountTypeSelect,accountType);
    }

    public void setInitialDepositInput(String initialDeposit) {
        setText(this.initialDepositInput,initialDeposit);
    }

    public void clickSubmitButton(){
        click(submitButton);
    }

    public void fillNewAccount(AccountEntity accountEntity){
        setCustomerIDInput(accountEntity.getCustomerId());
        selectAccountType(accountEntity.getAccountType());
        setInitialDepositInput(accountEntity.getInitialDeposit());
        Reporter.captureScreenshot(Ultilities.getCurrentMethodName());
    }

    public void addNewAccount(AccountEntity accountEntity){
        fillNewAccount(accountEntity);
        clickSubmitButton();
    }

    public void verifyCreateNewAccountSuccessful(){
        verifyElementVisible(accountId);
        Reporter.captureScreenshot(Ultilities.getCurrentMethodName());
    }

    public String getAccountID()
    {
        return getText(accountId);
    }
}
