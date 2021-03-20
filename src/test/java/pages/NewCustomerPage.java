package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.data.CustomerEntity;
import test.java.helper.Reporter;
import test.java.helper.Ultilities;

public class NewCustomerPage extends BasePage{
    @FindBy(xpath = "//input[@name='name']")
    public WebElement customerNameInput;

    @FindBy(xpath = "//input[@name='rad1' and @value='m']")
    public WebElement genderMaleRadio;

    @FindBy(xpath = "//input[@name='rad1' and @value='f']")
    public WebElement genderFemaleRadio;

    @FindBy(xpath = "//input[@id='dob']")
    public WebElement dateOfBirth;

    @FindBy(xpath = "//textarea[@name='addr']")
    public WebElement address;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement state;

    @FindBy(xpath = "//input[@name='pinno']")
    public WebElement pin;

    @FindBy(xpath = "//input[@name='telephoneno']")
    public WebElement mobileNumber;

    @FindBy(xpath = "//input[@name='emailid']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='sub']")
    public WebElement submitButton;

    @FindBy(xpath = "//td[text()='Customer ID']/following-sibling::td")
    public WebElement customerId;

    public void setCustomerNameInput(String customerNameInput){
        setText(this.customerNameInput,customerNameInput);
    }

    public void selectGender(boolean male){
        if(male)
            click(genderMaleRadio);
        else
            click(genderFemaleRadio);
    }
    public void setDateOfBirth(String dateOfBirth){
        setTextWithoutClear(this.dateOfBirth,dateOfBirth);
    }
    public void setAddress(String address){
        setText(this.address,address);
    }
    public void setCity(String city){
        setText(this.city,city);
    }
    public void setState(String state){
        setText(this.state,state);
    }
    public void setPin(String pin){
        setText(this.pin,pin);
    }
    public void setMobileNumber(String mobileNumber){
        setText(this.mobileNumber,mobileNumber);
    }
    public void setEmail(String email){
        setText(this.email,email);
    }
    public void setPassword(String password){
        setText(this.password,password);
    }
    public void clickSubmitButton(){
        click(submitButton);
    }

    public void fillNewCustomer(CustomerEntity customerEntity){
        setCustomerNameInput(customerEntity.getCustomerName());
        selectGender(customerEntity.isMale());
        setDateOfBirth(customerEntity.getDateOfBirth());
        setAddress(customerEntity.getAddress());
        setCity(customerEntity.getCity());
        setState(customerEntity.getState());
        setPin(customerEntity.getPin());
        setMobileNumber(customerEntity.getMobileNumber());
        setEmail(customerEntity.getEmail());
        setPassword(customerEntity.getPassword());
        Reporter.captureScreenshot(Ultilities.getCurrentMethodName());
    }

    public void addNewCustomer(CustomerEntity customerEntity){
        fillNewCustomer(customerEntity);
        clickSubmitButton();
    }

    public String getNewCustomerId(){
        return getText(customerId);
    }

    public void verifyAddCustomerSuccessful(){
        verifyElementVisible(customerId);
        Reporter.captureScreenshot(Ultilities.getCurrentMethodName());
    }
}
