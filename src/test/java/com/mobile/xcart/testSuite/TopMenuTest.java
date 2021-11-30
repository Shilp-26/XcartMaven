package com.mobile.xcart.testSuite;


import com.mobile.xcart.pages.Homepage;
import com.mobile.xcart.testbase.TestBase;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {

    Homepage homepage =new Homepage();

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully(){
        homepage.clickOnShippingTab();
        homepage.verifyShippingTitle();
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        homepage.clickOnNewTab();
        homepage.verifyNewTitle();
    }
    @Test
    public void verifyUserShouldNavigateToComingSoonPageSuccessfully(){
        homepage.clickOnComingSoonTab();
        homepage.verifyComingSoonTitle();
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        homepage.clickOnContactUsTab();
        homepage.verifyContactUsTitle();
    }

}
