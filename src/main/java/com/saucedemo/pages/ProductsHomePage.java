package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customelisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ProductsHomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement productsText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='inventory_item']")
    List<WebElement> numProducts;

    public String getProductsText(){
        Reporter.log("Getting Product text" + productsText.toString());
        CustomListeners.test.log(Status.PASS, "Getting Product Text");
        return getTextFromElement(productsText);
    }

    public int findActualNumberOfProducts(){
        Reporter.log("Finding total number of Products");
        CustomListeners.test.log(Status.PASS, "Finding total number of Products");
        return numProducts.size();
    }

}
