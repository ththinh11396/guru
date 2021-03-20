package test.java.data;

import test.java.helper.Ultilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerEntity {
    String customerName;
    boolean isMale;
    String dateOfBirth;
    String address;
    String city;
    String state;
    String pin;
    String mobileNumber;
    String email;
    String password;
    String customerId;

    public CustomerEntity(){

    }

    public CustomerEntity(String customerName, boolean isMale, String dateOfBirth, String address, String city, String state, String pin, String mobileNumber, String email, String password) {
        this.customerName = customerName;
        this.isMale = isMale;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pin = pin;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
    }

    public void createRandomCustomer(){
        this.customerName = "Customer";
        this.isMale = true;
        this.dateOfBirth = "01/02/2012";
        this.address = "Address"+Ultilities.getCurrentTime();
        this.city = "HCM";
        this.state = "State";
        this.pin = Ultilities.generateNumber(6);
        this.mobileNumber = "0"+Ultilities.generateNumber(8);
        this.email = "email"+Ultilities.getCurrentTime()+"@nomail.com";
        this.password = "P@ssw0rd"+Ultilities.generateNumber(6);
        this.customerId="";
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
