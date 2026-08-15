package com.icon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.icon.base.Base;
import com.icon.pages.HomePage;



public class HomePageTest extends Base {

    @Test
    public void verifyNameField() {

        HomePage homePage = new HomePage(driver);

        homePage.enterName("Icon");

        Assert.assertEquals(homePage.getNameValue(), "Icon");
    }
}