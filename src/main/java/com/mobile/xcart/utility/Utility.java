package com.mobile.xcart.utility;


import com.mobile.xcart.driverManager.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.annotation.Nullable;
import java.time.Duration;
import java.util.Random;
import java.util.function.Function;

public class Utility extends DriverManager {
    /**
     * @param by
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * @param by
     * @return
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * @param by
     * @param keys
     */


    public void sendKeysToElement(By by, CharSequence keys) {
        driver.findElement(by).sendKeys(keys);
    }

    // This method will send text to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    /**
     *
     * @param by
     * @param text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select sel = new Select(dropDown);
        sel.selectByVisibleText(text);
    }

    /**
     *
     * @param by
     * @throws InterruptedException
     */
    public void mouseHoverOnly(By by)  {
        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        actions.moveToElement(mouseHover).build().perform();
    }

    /**
     *
     * @param by
     * @param time
     * @return
     */
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }
    public String getTextFromAlert() {
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        System.out.println(textOnAlert);
        return textOnAlert;
    }
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    /**
     *
     * @param by
     * @param time
     * @param poll
     * @return
     */
    public WebElement   waitForElementWithFluentWait(By by,int time,int poll){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(poll))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }
    public void verifyText(String expectedMessage, By by, String displayMessage) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }
    public void verifyTextOld(String exceptedMessage, String actualMessage, @Nullable String errorMessage) {
        Assert.assertEquals(errorMessage == null ? "" : errorMessage, exceptedMessage, actualMessage);
    }
    public void mouseHoverClick(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHoover).click().build().perform();
    }
    public String getRandomEmail() {
        String saltChars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        while (email.length() < 10) {
            int index = (int) (random.nextFloat() * saltChars.length());
            email.append(saltChars.charAt(index));
        }
        String saltStr = (email.toString() + "@gmail.com");
        return saltStr;
    }



}
