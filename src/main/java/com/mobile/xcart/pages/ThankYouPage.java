package com.mobile.xcart.pages;

import com.mobile.xcart.utility.Utility;
import org.openqa.selenium.By;

public class ThankYouPage extends Utility {

    By verifyThankYou = By.xpath("//h1[contains(.,'Thank you for your order')]");

    public void verifyThankYouMsg(){
        verifyText("Thank you for your order",verifyThankYou, "Error, Message not displayed as expected");

    }
}
