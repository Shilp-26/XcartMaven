package com.mobile.xcart.pages;


import com.mobile.xcart.utility.Utility;
import org.openqa.selenium.By;

public class Homepage extends Utility {

    By navigateToShipping = By.xpath("(//span[contains(text(),'Shipping')])[2]");
    By verifyShipping=By.xpath("//h1[@id='page-title']");
    By navigateToNew = By.xpath("(//span[contains(text(),'New!')])[2]");
   By verifyNew=By.xpath("//h1[@id='page-title']");
    By navigateToComingSoon = By.xpath("(//span[contains(text(),'Coming soon')])[2]");
   By verifyComingSoon=By.xpath("//h1[@id='page-title']");
    By navigateToContactUs = By.xpath("(//span[contains(text(),'Contact us')])[2]");
   By verifyContactUs=By.xpath("//h1[@id='page-title']");

   public void clickOnShippingTab(){
      clickOnElement(navigateToShipping);
   }
    public void clickOnNewTab(){
        clickOnElement(navigateToNew);
    }
    public void clickOnComingSoonTab(){
        clickOnElement(navigateToComingSoon);
    }
    public void clickOnContactUsTab(){
        clickOnElement(navigateToContactUs);
    }
    public void verifyShippingTitle(){
       verifyText("Shipping",verifyShipping,"Page not found");
    }
    public void verifyNewTitle(){
        verifyText("New arrivals",verifyNew,"Page not found");
    }
    public void verifyComingSoonTitle(){
        verifyText("Coming soon",verifyComingSoon,"Page not found");
    }
    public void verifyContactUsTitle(){
        verifyText("Contact us",verifyContactUs,"Page not found");
    }
}
