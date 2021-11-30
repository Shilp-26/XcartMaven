package com.mobile.xcart.pages;

import com.mobile.xcart.utility.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestSellersPage extends Utility {

    By hoverHotDeals = By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']");
    By clickBestSeller = By.xpath("(//span[contains(text(),'Bestsellers')])[2]");
    By verifyBestSellersText = By.xpath("//h1[@id='page-title']");
    By hoverSortBy = By.xpath("//span[@class='sort-by-label']");
    By clickOnZToA = By.xpath("(//a[normalize-space()='Name Z - A'])[1]");
    By clickOnAToZ = By.xpath("//a[normalize-space()='Name A - Z']");
    By allProductsBestseller = By.xpath("//h5[@class='product-name']");
    By allProductPrices = By.xpath("//li[contains(@class,'product-price-base')]");
    By clickHighToLow = By.xpath("//a[normalize-space()='Price High - Low']");
    By allProductRates = By.cssSelector(".stars-row.full");
    By hoverOnProduct = By.xpath("//a[@class='product-thumbnail next-previous-assigned']");
    By addToCartProduct = By.xpath("//button[contains(@class,'btn  regular-button add-to-cart product-add2cart productid-13')]");
    By verifyMsg = By.xpath("//li[contains(text(),'Product has been added to your cart')]");
    By clickOnX = By.xpath("//a[@title='Close']");
    By clickOnYourCart = By.xpath("//div[@title='Your cart']");
    By viewYourCart = By.xpath("//a[@class='regular-button cart']");
    By clickOnRates = By.xpath("//a[normalize-space()='Rates']");


public void clickOnXBtn(){
    clickOnElement(clickOnX);
}
public void clickOnYourCart(){
    clickOnElement(clickOnYourCart);
}

    public void clickOnViewCart(){
        clickOnElement(viewYourCart);
    }
    public void clickOnBestSellers() {
        mouseHoverOnly(hoverHotDeals);
        clickOnElement(clickBestSeller);
    }

    public void verifyBestSellerTxt() {
        verifyText("Bestsellers", verifyBestSellersText, "Page not found");

    }

    public void verifyProductAddedMSg() {
        verifyText("Product has been added to your cart", verifyMsg, "Error, Message not displayed");

    }

    public void selectAToZ() {
        mouseHoverOnly(hoverSortBy);
        clickOnElement(clickOnAToZ);
    }

    public void addProductToCart() {
        mouseHoverOnly(hoverOnProduct);
        clickOnElement(addToCartProduct);
    }

    public void selectZToA() {
        mouseHoverOnly(hoverSortBy);
        clickOnElement(clickOnZToA);
    }

    public void verifyZToA() {
        List<WebElement> originalList = driver.findElements(allProductsBestseller);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductNameList.add(product.getText());
        }
        originalProductNameList.sort(String.CASE_INSENSITIVE_ORDER.reversed());
        System.out.println(originalProductNameList);

        waitUntilVisibilityOfElementLocated(allProductsBestseller, 10);

        List<WebElement> afterSortingList = driver.findElements(allProductsBestseller);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductName.add(product.getText());
        }
        //   System.out.println(allProductsBestseller);
        System.out.println(afterSortingProductName);

        Assert.assertEquals("Product not sorted", originalProductNameList, afterSortingProductName);
    }

    public void selectHighToLow() {
        mouseHoverOnly(hoverSortBy);
        clickOnElement(clickHighToLow);
    }

    public void verifyHighToLow() {
        List<WebElement> originalList = driver.findElements(allProductPrices);
        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductPriceList.add(Double.parseDouble(product.getText().substring(1)));
        }
        originalProductPriceList.sort(Double::compareTo);
        List<Double> reverseProductPriceList = new ArrayList<>();
        for (int i = 1; i <= originalProductPriceList.size(); i++) {
            reverseProductPriceList.add(originalProductPriceList.get(originalProductPriceList.size() - i));
        }
        System.out.println(reverseProductPriceList);
        waitUntilVisibilityOfElementLocated(allProductPrices, 10);
        List<WebElement> afterSortingList = driver.findElements(allProductPrices);
        List<Double> afterSortingProductName = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductName.add(Double.parseDouble(product.getText().substring(1)));
        }
        System.out.println(afterSortingProductName);
        Assert.assertEquals("Product not sorted", reverseProductPriceList, afterSortingProductName);
    }

    public void selectRates() {
        mouseHoverOnly(hoverSortBy);
        clickOnElement(clickOnRates);
    }

    public void verifyRates() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(allProductRates);
        List<Integer> originalProductRateList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductRateList.add(Integer.parseInt(product.getAttribute("style").substring(7, 9)));
        }
        originalProductRateList.sort(Collections.reverseOrder());
        System.out.println(originalProductRateList);
        waitUntilVisibilityOfElementLocated(allProductRates, 10);
        List<WebElement> afterSortList = driver.findElements(allProductRates);
        List<Integer> afterSortProductRates = new ArrayList<>();
        for (WebElement product : afterSortList) {
            afterSortProductRates.add(Integer.parseInt(product.getAttribute("style").substring(7, 9)));
        }
        System.out.println(afterSortProductRates);
        Assert.assertEquals("Products not sorted", originalProductRateList, afterSortProductRates);
    }


}



