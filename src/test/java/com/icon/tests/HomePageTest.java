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
    
    @Test
    public void verifyMaleRadioButtonSelection() {

        HomePage homePage = new HomePage(driver);

        Assert.assertFalse(
                homePage.getMaleRadioButton().isSelected(),
                "Male radio button is already selected before clicking"
        );
        homePage.clickMaleRadioButton();
        Assert.assertTrue(
                homePage.getMaleRadioButton().isSelected(),
                "Male radio button was not selected after clicking"
        );
    }
    
    @Test
    public void verifyDoubleClick() {

        HomePage homePage = new HomePage(driver);
        homePage.field1("Icon");
        String actualText = homePage.doubleclickme();
        System.out.println(actualText);
        String  expectedText = "Icon";

        Assert.assertEquals(
                actualText,
               expectedText
        );
    }
    @Test
    public void verifyMouseHover() {
    	HomePage homePage = new HomePage(driver);
    	homePage.mouseHoverOnPointMe();
        Assert.assertTrue(
                homePage.isMobilesDisplayed(),
                "No mobile is found"
        );
    }

}