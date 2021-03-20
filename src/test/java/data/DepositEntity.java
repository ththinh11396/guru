package test.java.data;

import test.java.helper.Ultilities;
import test.java.pages.BasePage;

public class DepositEntity extends BasePage {

    String accountNo;
    String amount;
    String description;

    public DepositEntity(){

    }

    public DepositEntity(String accountNo, String amount, String description) {
        this.accountNo = accountNo;
        this.amount = amount;
        this.description = description;
    }

    public void createRandomDeposit(String accountNo){
        this.accountNo = accountNo;
        this.amount = Ultilities.generateNumber(5);
        this.description = "Pay";
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
