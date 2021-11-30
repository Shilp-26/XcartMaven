package com.mobile.xcart.testSuite;

import com.mobile.xcart.pages.BestSellersPage;
import com.mobile.xcart.pages.ShoppingCartPage;
import com.mobile.xcart.testbase.TestBase;
import org.testng.annotations.Test;

public class BestsellersTest extends TestBase {

    BestSellersPage bestSellersPage = new BestSellersPage();
    ShoppingCartPage shoppingCartPage =new ShoppingCartPage();


    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        bestSellersPage.clickOnBestSellers();
        bestSellersPage.verifyBestSellerTxt();
        bestSellersPage.selectAToZ();
        bestSellersPage.addProductToCart();
        bestSellersPage.verifyProductAddedMSg();
        bestSellersPage.clickOnXBtn();
        bestSellersPage.clickOnYourCart();
        bestSellersPage.clickOnViewCart();

        shoppingCartPage.verifyShoppingCartMSg();
        shoppingCartPage.clickOnEmptyCart();
        shoppingCartPage.verifyAlertMSg();
        shoppingCartPage.verifyIfItemsDeleted();
        shoppingCartPage.verifyIfCartIsEmpty();

    }
}
