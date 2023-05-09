package com.saucedemo.testsuite;

import com.saucedemo.customelisteners.CustomListeners;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsHomePage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    ProductsHomePage productsHomePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        productsHomePage = new ProductsHomePage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        loginPage.sendTextToUsernameField("standard_user");
        loginPage.sendTextToPasswordField("secret_sauce");
        loginPage.clickOnLoginButton();
        String expectedText = "Products";
        String actualText = productsHomePage.getProductsText();
        Assert.assertEquals(actualText, expectedText, "No text Found");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatSixProductsAreDisplayedOnPage(){
        loginPage.sendTextToUsernameField("standard_user");
        loginPage.sendTextToPasswordField("secret_sauce");
        loginPage.clickOnLoginButton();
        int expectedNumberOfProducts = 6;
        int actualNumberOfProducts = productsHomePage.findActualNumberOfProducts();
        Assert.assertEquals(expectedNumberOfProducts, actualNumberOfProducts, "Number of Products do not match");
    }
}