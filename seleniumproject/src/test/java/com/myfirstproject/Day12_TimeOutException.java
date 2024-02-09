package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Day12_TimeOutException extends TestBase {

    @Test
    public void noSuchElementException() {
        driver.get("https://www.amazon.com");
        waitFor(2);
        driver.navigate().refresh();

//        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));  // correct locator
//        searchBox.sendKeys("porcelain teapot", Keys.ENTER);


//        WebElement searchBox = driver.findElement(By.id("two  tabsearchtextbox"));  // WRONG locator
//        searchBox.sendKeys("porcelain teapot", Keys.ENTER);

//      This will throw NoSuchElement Exception because element cant be located

//      Let's say, this failure is because of time issue and not locator reason, So we try to add EXPLICIT WAIT (reusable method)

        WebElement searchBox = waitForVisibility(By.id("two tabsearchtextbox"), 10);
        searchBox.sendKeys("porcelain teapot", Keys.ENTER);

    }
}
