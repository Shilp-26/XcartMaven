package com.mobile.xcart.pages;

import com.mobile.xcart.utility.Utility;
import org.openqa.selenium.By;

public class LogInToYourAccount extends Utility {

    By verifyLogInMsg = By.xpath("//h3[contains(text(),'Log in to your account')]");
    By inputEmail = By.id("email");
    By continueBtn = By.xpath("//button[contains(@class,'regular-button anonymous-continue-button submit')]");


    public void verifyLogInMsg() {
        verifyText("Log in to your account", verifyLogInMsg, "Page not found");

    }
    public void enterEmail(){
        sendKeysToElement(inputEmail,getRandomEmail());
    }
    public void clickOnContinue(){
        clickOnElement(continueBtn);
    }
}
