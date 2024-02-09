package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Day12_StaleElementException extends TestBase {

    @Test
    public void staleElementTest() {

        driver.get("https://www.amazon.com");
        waitFor(2);
        driver.navigate().refresh();

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));  // correctlocator
        searchBox.sendKeys("porcelain teapot", Keys.ENTER);
        waitFor(2);
        driver.navigate().to("https://www.google.com");
        waitFor(2);
        driver.navigate().back();  // back to amazon
        //  searchBox.sendKeys("iPhone 15");  // StaleElementReferenceException  Test fails here

        // SOLUTION
        // You have to refresh the reference of that element (in this case searchBox element)
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Iphone 15");
    }


}
