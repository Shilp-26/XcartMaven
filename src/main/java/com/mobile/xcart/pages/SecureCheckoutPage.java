package com.mobile.xcart.pages;

import com.mobile.xcart.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SecureCheckoutPage extends Utility {

    By verifyMsg = By.xpath("//h1[normalize-space()='Secure Checkout']");
    By firstName = By.xpath("//input[@id='shippingaddress-firstname']");
    By lastName = By.xpath("//input[@id='shippingaddress-lastname']");
    By address = By.xpath("//input[@id='shippingaddress-street']");
    By city = By.xpath("//input[@id='shippingaddress-city']");
    By selectCountry = By.xpath("//select[@id='shippingaddress-country-code']");
    By state = By.xpath("//input[@id='shippingaddress-custom-state']");
    By zipCode = By.xpath("//input[@id='shippingaddress-zipcode']");
    By createAccountForLaterUse = By.xpath("//input[@id='create_profile']");
    By enterPassword = By.xpath("//input[@id='password']");
    By localShipping = By.id("method128");
    By selectCod = By.xpath("//span[normalize-space()='COD']");
    By verifyFinalTotal = By.xpath("//span[contains(text(),'$37.03')]");
    By placeOrderBtn = By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']");


    public void verifySecureMsg() {
        verifyText("Secure Checkout", verifyMsg, "Page not found");
    }

    public void inputFirstName() {
        sendTextToElement(firstName, "Shilp");
    }

    public void inputLastName() {
        sendTextToElement(lastName, "Patel");
    }

    public void inputAddress() {
        sendTextToElement(address, "69 Haydon Drive");
    }

    public void inputCity() {
        sendKeysToElement(city, Keys.BACK_SPACE + "London");
    }

    public void selectCountry() {
        selectByVisibleTextFromDropDown(selectCountry, "United Kingdom");
    }

    public void inputState() {
        sendTextToElement(state, "London");
    }

    public void inputZipCode() {
        sendKeysToElement(zipCode, Keys.BACK_SPACE + "3");
    }

    public void clickOnAccountForLater() {
        clickOnElement(createAccountForLaterUse);
    }

    public void enterPassword() {
        sendTextToElement(enterPassword, "Prime456");
    }

    public void selectLocalShipping() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(localShipping);
    }

    public void selectCodOption() {
        clickOnElement(selectCod);
    }

    public void verifyFinalTotal() {
        verifyText("Place order: $37.03", verifyFinalTotal, "Error, Message not displayed as expected");

    }

    public void clickOnPlaceOrderBtn() {
        clickOnElement(placeOrderBtn);
    }
}
