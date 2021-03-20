package test.java.data;

import test.java.common.Constant;
import test.java.helper.Ultilities;

public class AccountEntity {
    String customerId;
    String accountType;
    String initialDeposit;

    public AccountEntity(){

    }

    public AccountEntity(String customerId, String accountType, String initialDeposit) {
        this.customerId = customerId;
        this.accountType = accountType;
        this.initialDeposit = initialDeposit;
    }

    public void createRandomAccount(String customerId){
        this.customerId = customerId;
        this.accountType = Constant.ACCOUNT_TYPE_SAVINGS;
        this.initialDeposit = Ultilities.generateNumber(6);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(String initialDeposit) {
        this.initialDeposit = initialDeposit;
    }
}
