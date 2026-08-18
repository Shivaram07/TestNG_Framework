package com.icon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private WebDriver driver;

    private By nameInput = By.id("name");
    private By maleRadioButton = By.id("male");
    private By field1 = By.id("field1");
    private By field2 = By.id("field2");
    private By moverHoverbutton = By.xpath("//button[text() = 'Point Me']");
    private By mobiles = By.xpath("//div[@class = 'dropdown']//a[normalize-space()='Mobiles']");
    private Actions actions;
    private By doubleClick = By.xpath("//button[contains(text(), 'Copy Text')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public String getNameValue() {
        return driver.findElement(nameInput).getAttribute("value");
    }

    public WebElement getMaleRadioButton() {
        return driver.findElement(maleRadioButton);
    }

    public void clickMaleRadioButton() {
        driver.findElement(maleRadioButton).click();
    }
    
   public void field1(String f1)
   {    driver.findElement(field1).clear();
	   driver.findElement(field1).sendKeys(f1);
	   
	   
   }
   public String doubleclickme() {
	   WebElement button = driver.findElement(doubleClick);
	   actions.doubleClick(button).perform();
	  String f2 =  driver.findElement(field2).getAttribute("value");
	  return f2;
   }
   
   public void mouseHoverOnPointMe() {

       WebElement pointMeButton = driver.findElement(moverHoverbutton);

       actions.moveToElement(pointMeButton).perform();
   }

   public boolean isMobilesDisplayed() {
             System.out.println("Mobile is present");
       return driver.findElement(mobiles).isDisplayed();
       
   }
   
   
}