package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.helper.ConfigProperties;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@name='uid']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement userPasswordInput;

    @FindBy(xpath = "//input[@name='btnLogin']")
    public WebElement loginButton;

    public void setUserNameInput(String userEmail){
        setText(userNameInput,userEmail);
    }

    public void setPasswordInput(String userPassword){
        setText(userPasswordInput,userPassword);
    }

    public LoginPage clickLoginButton(){
        click(loginButton);
        return this;
    }

    public void login(String username,String password){
        setUserNameInput(username);
        setPasswordInput(password);
        clickLoginButton();
    }

    public void login(){
        login(ConfigProperties.getUsername(),ConfigProperties.getPassword());
    }
}
