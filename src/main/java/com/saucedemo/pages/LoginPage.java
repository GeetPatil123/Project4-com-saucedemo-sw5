package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customelisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "user-name")
    WebElement userNameField;

    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "login-button")
    WebElement loginButton;

    public void sendTextToUsernameField(String username) {
        Reporter.log("Enter Username " + username + " to username field " + userNameField.toString());
        sendTextToElement(userNameField,username);
        CustomListeners.test.log(Status.PASS, "Enter Username " + username);
    }

    public void sendTextToPasswordField(String password) {
        Reporter.log("Enter password " + password + " to password field" + passwordField.toString());
        sendTextToElement(passwordField,password);
        CustomListeners.test.log(Status.PASS, "Enter password" + password);
    }
    public void clickOnLoginButton(){
        Reporter.log("Click Login Button " + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click Login Button");
    }
}
