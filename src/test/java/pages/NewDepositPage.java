package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.data.DepositEntity;
import test.java.helper.Reporter;
import test.java.helper.Ultilities;

public class NewDepositPage extends BasePage{
    @FindBy(xpath = "//input[@name='accountno']")
    public WebElement accountNo;

    @FindBy(xpath = "//input[@name='ammount']")
    public WebElement amount;

    @FindBy(xpath = "//input[@name='desc']")
    public WebElement description;

    @FindBy(xpath = "//input[@name='AccSubmit']")
    public WebElement submitButton;

    @FindBy(xpath = "//td[text()='Transaction ID']/following-sibling::td")
    public WebElement transactionId;

    public void setAccountNo(String accountNo){
        setText(this.accountNo,accountNo);
    }

    public void setAmount(String amount){
        setText(this.amount,amount);
    }

    public void setDescription(String description){
        setText(this.description,description);
    }

    public void fillNewDeposit(DepositEntity depositEntity){
        setAccountNo(depositEntity.getAccountNo());
        setAmount(depositEntity.getAmount());
        setDescription(depositEntity.getDescription());
    }

    public void createNewDeposit(DepositEntity depositEntity){
        fillNewDeposit(depositEntity);
        clickSubmitButton();
    }

    public void clickSubmitButton(){
        click(submitButton);
    }

    public String getTransactionId(){
        return getText(transactionId);
    }

    public void verifyCreateDepositSuccessful(){
        verifyElementVisible(transactionId);
        Reporter.captureScreenshot(Ultilities.getCurrentMethodName());
    }
}
