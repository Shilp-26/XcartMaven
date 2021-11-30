package com.mobile.xcart.pages;

import com.mobile.xcart.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ShoppingCartPage extends Utility {

    By verifyShoppingMsg = By.xpath("//h1[contains(text(),'Your shopping cart - 1 item')]");
    By changeQuantity = By.xpath("//input[contains(@id, 'amount16')]");
    By verifyShoppingMsg2 = By.xpath("//h1[contains(text(),'Your shopping cart - 2 item')]");
    By verifySubTotal1 = By.xpath("//ul[@class='sums']//span[@class='part-integer'][normalize-space()='29']");
    By verifySubTotal2 = By.xpath("//ul[@class='sums']//span[@class='part-decimal'][normalize-space()='98']");
    By verifyTotal1 = By.xpath("//span[normalize-space()='36']");
    By verifyTotal2 = By.xpath("//span[normalize-space()='00']");
    By goToCheckout = By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]");
    By emptyYourCart = By.xpath("//a[normalize-space()='Empty your cart']");
    By verifyItemsDeleted = By.xpath("//li[contains(.,'Item(s) deleted from your cart')]");
    By verifyCartIsEmpty = By.xpath("//h1[contains(.,'Your cart is empty')]");


    public void verifyShoppingCartMSg() {
        verifyText("Your shopping cart - 1 item", verifyShoppingMsg, "Error");
    }
public void verifyIfItemsDeleted() throws InterruptedException {
    verifyText("Item(s) deleted from your cart", verifyItemsDeleted, "Error, Message not displayed");
Thread.sleep(2000);
}

    public void verifyIfCartIsEmpty() throws InterruptedException {
        verifyText("Your cart is empty",verifyCartIsEmpty, "Error, Message not displayed");
        Thread.sleep(2000);
    }


    public void clickOnGoToCheckout() {
        clickOnElement(goToCheckout);
    }

    public void verifyAlertMSg() throws InterruptedException {
        Thread.sleep(2000);
        String message = getTextFromAlert();
        verifyTextOld("Are you sure you want to clear your cart?", message, "Error, Message not displayed as expected");
        acceptAlert();
    }

    public void clickOnEmptyCart() {
        clickOnElement(emptyYourCart);
    }

    public void modifyQuantity() {
        sendKeysToElement(changeQuantity, Keys.BACK_SPACE + "2");
    }

    public void verifyCart2ItemsMsg() {
        verifyText("Your shopping cart - 2 items", verifyShoppingMsg2, "Error, Message not displayed as expected");

    }

    public void verifySubTotal1() {
        verifyText("29", verifySubTotal1, "Error, Message not displayed as expected");

    }

    public void verifySubTotal2() {
        verifyText("98", verifySubTotal2, "Error, Message not displayed as expected");
    }

    public void verifyTotal1() {
        verifyText("36", verifyTotal1, "Error, Message not displayed as expected");

    }

    public void verifyTotal2() {
        verifyText("00", verifyTotal2, "Error, Message not displayed as expected");

    }
}