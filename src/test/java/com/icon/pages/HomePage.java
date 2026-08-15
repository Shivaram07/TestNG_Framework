package com.icon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By nameInput = By.id("nme");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }
    public String getNameValue() {
        return driver.findElement(nameInput).getAttribute("value");
    }
}