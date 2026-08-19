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
    private By datePicker1 = By.id("datepicker");

    private By datePickerMonth =
            By.xpath("//span[@class='ui-datepicker-month']");

    private By datePickerYear =
            By.xpath("//span[@class='ui-datepicker-year']");

    private By nextMonth =
            By.xpath("//span[contains(text() ,'Next')]");

    private By previousMonth =
            By.xpath("//span[contains(text() ,'Prev')]");

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
   private By getDate(String day) {
       return By.xpath(
               "//table[contains(@class,'ui-datepicker-calendar')]" +
               "//a[normalize-space()='" + day + "']"
       );
   }

   public void selectDate(String month, String year, String day) {

       driver.findElement(datePicker1).click();

       int targetMonth = getMonthNumber(month);
       int targetYear = Integer.parseInt(year);

       while (true) {

           String currentMonth =
                   driver.findElement(datePickerMonth).getText();

           String currentYear =
                   driver.findElement(datePickerYear).getText();

           int currentMonthNumber =
                   getMonthNumber(currentMonth);
           int currentYearNumber =
                   Integer.parseInt(currentYear);

           if (currentMonthNumber == targetMonth
                   && currentYearNumber == targetYear) {
               break;
           }

           if (currentYearNumber < targetYear
                   || (currentYearNumber == targetYear
                   && currentMonthNumber < targetMonth)) {

               driver.findElement(nextMonth).click();

           } else {

               driver.findElement(previousMonth).click();
           }
       }

       driver.findElement(getDate(day)).click();
   }

   private int getMonthNumber(String month)
   {

       switch (month.toLowerCase()) {

       case "january": return 1;
       case "february": return 2;
       case "march": return 3;
       case "april": return 4;
       case "may": return 5;
       case "june": return 6;
       case "july": return 7;
       case "august": return 8;
       case "september": return 9;
       case "october": return 10;
       case "november": return 11;
       case "december": return 12;

       default:
           throw new IllegalArgumentException(
                   "Invalid month: " + month
        		   );
       }
   }

   public String getSelectedDate() {
       return driver.findElement(datePicker1)
               .getAttribute("value");
   }
   
   
}