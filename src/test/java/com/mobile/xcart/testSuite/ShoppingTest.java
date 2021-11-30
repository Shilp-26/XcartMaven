package com.mobile.xcart.testSuite;

import com.mobile.xcart.pages.*;
import com.mobile.xcart.testbase.TestBase;
import org.testng.annotations.Test;

public class ShoppingTest extends TestBase {

    SalePage salePage = new SalePage();
    ShoppingCartPage shoppingCartPage= new ShoppingCartPage();
    LogInToYourAccount logInToYourAccount = new LogInToYourAccount();
    SecureCheckoutPage secureCheckoutPage = new SecureCheckoutPage();
    ThankYouPage thankYouPage = new ThankYouPage();


    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengersFabrikationsPlush() throws InterruptedException {
        salePage.navigateToSales();
        salePage.verifySaleTxt();
        salePage.sortAToZ();
        salePage.mouseHoverOnProduct();
        Thread.sleep(2000);
        salePage.addProductToCart();
        salePage.verifyProductAdded();
        salePage.clickOnX();
        salePage.clickOnYourCartBtn();
        salePage.clickOnViewCartBtn();

        shoppingCartPage.verifyShoppingCartMSg();
        shoppingCartPage.modifyQuantity();
        Thread.sleep(2000);
        shoppingCartPage.verifyCart2ItemsMsg();
        shoppingCartPage.verifySubTotal1();
        shoppingCartPage.verifySubTotal2();
        shoppingCartPage.verifyTotal1();
        shoppingCartPage.verifyTotal2();
        shoppingCartPage.clickOnGoToCheckout();

        logInToYourAccount.verifyLogInMsg();
        logInToYourAccount.enterEmail();
        logInToYourAccount.clickOnContinue();

        secureCheckoutPage.verifySecureMsg();
        secureCheckoutPage.inputFirstName();
        secureCheckoutPage.inputLastName();
        secureCheckoutPage.inputAddress();
        secureCheckoutPage.inputCity();
        secureCheckoutPage.selectCountry();
        secureCheckoutPage.inputState();
        secureCheckoutPage.inputZipCode();
        secureCheckoutPage.clickOnAccountForLater();
        secureCheckoutPage.enterPassword();
        secureCheckoutPage.selectLocalShipping();
        secureCheckoutPage.selectCodOption();
        secureCheckoutPage.verifyFinalTotal();
        Thread.sleep(2000);
        secureCheckoutPage.clickOnPlaceOrderBtn();
        Thread.sleep(2000);

        thankYouPage.verifyThankYouMsg();





    }

}
