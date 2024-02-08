package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day12_ExplicitWait extends TestBase {

//    Create a class:ExplicitWait
//    Create a method: explicitWait
//    Go to https://the-internet.herokuapp.com/dynamic_loading/1


    @Test
    public void explicitWaitTest() {
//    Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//    When user clicks on the Start button
        WebElement startButton = driver.findElement(By.xpath("//*[text()='Start']"));
        startButton.click();

//      NOTE: The driver is unable to lacate the successMessage element because it's not synchronised with the element
//      successMessage element need time to load and be available for the driver to see
//      SOLUTION: Add EXPLICIT WAIT for this element only


        WebElement successMessage = driver.findElement(By.xpath("//div[@id='finish']//h4"));

        /*
        1- Create the wait object
        2- pass the webElement / locator in the ExpectedConditions. whatever method you need
         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.visibilityOf(successMessage));  // Pass the webElement in visibilty OR
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4"))); // Pass the locator directly in this method

//    Then verify the ‘Hello World!’ Shows up on the screen
        Assertions.assertTrue(successMessage.getText().contains("Hello World!"));


    }

}
