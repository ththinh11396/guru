package test.java.test;

import org.testng.annotations.Test;
import test.java.data.AccountEntity;
import test.java.data.CustomerEntity;
import test.java.data.DepositEntity;
import test.java.helper.ConfigProperties;
import test.java.helper.Reporter;
import test.java.pages.*;

public class BankGuruTest extends BaseTest{

    @Test(testName = "Guru bank demo")
    public void BankGuru_Test()  {
        try{
            String customerId;
            String accountId;

            CustomerEntity customerEntity = new CustomerEntity();
            AccountEntity accountEntity = new AccountEntity();
            DepositEntity depositEntity = new DepositEntity();

            customerEntity.createRandomCustomer();

            ManagerHomePage managerHomePage = new ManagerHomePage();
            LoginPage loginPage = new LoginPage();
            NewCustomerPage addCustomerPage = new NewCustomerPage();
            NavigationBarPage navigationBarPage = new NavigationBarPage();
            NewAccountPage newAccountPage = new NewAccountPage();
            NewDepositPage newDepositPage = new NewDepositPage();

            Reporter.createScenarioNote("Scenario 1 : Verify new customer can be created.");
            Reporter.createNote("Given Go to "+ConfigProperties.getURL());
            managerHomePage.goToBaseURL();

            Reporter.createNote("When I log in with account "+ConfigProperties.getUsername());
            loginPage.login();

            Reporter.createNote("Then manager home page display ");
            managerHomePage.verifyHomePageDisplay();

            Reporter.createNote("Given I go to New Customer menu");
            navigationBarPage.clickNewCustomerMenu();

            Reporter.createNote("When I create new customer");
            addCustomerPage.addNewCustomer(customerEntity);

            Reporter.createNote("Then create new customer successful page display");
            addCustomerPage.verifyAddCustomerSuccessful();
            customerId = addCustomerPage.getNewCustomerId();

            Reporter.createScenarioNote("Scenario 2 : Verify to create new account based on the customer just created above.");
            accountEntity.createRandomAccount(customerId);

            Reporter.createNote("Given I go to New Account menu");
            navigationBarPage.clickNewAccountMenu();

            Reporter.createNote("When I create new account");
            newAccountPage.addNewAccount(accountEntity);

            Reporter.createNote("Then create new account successful page display");
            newAccountPage.verifyCreateNewAccountSuccessful();
            accountId = newAccountPage.getAccountID();

            Reporter.createScenarioNote("Scenario 3 : Verify deposit function work fine with the account just created.");
            Reporter.createNote("Given I go to Deposit menu");
            navigationBarPage.clickDepositMenu();

            Reporter.createNote("When create new deposit");
            depositEntity.createRandomDeposit(accountId);
            newDepositPage.createNewDeposit(depositEntity);

            Reporter.createNote("Then create new deposit successful page display");
            newDepositPage.verifyCreateDepositSuccessful();

        }catch (Exception e){
            Reporter.createFailNote(e.getMessage());
        }
    }
}
