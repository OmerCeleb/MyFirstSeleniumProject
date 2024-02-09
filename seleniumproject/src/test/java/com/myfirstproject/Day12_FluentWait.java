package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Day12_FluentWait extends TestBase {

    @Test
    public void fluentWait() {

//    Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//    When user clicks on the Start button
        WebElement startButton = driver.findElement(By.xpath("//*[text()='Start']"));
        startButton.click();

//      NOTE: The driver is unable to lacate the successMessage element because it's not synchronised with the element
//      successMessage element need time to load and be available for the driver to see

//      SOLUTION: Add EXPLICIT WAIT for this element only and this will make the driver poll in (peep in) after
//      every 2 seconds (or given time), if the element is available/loaded, driver will perform its function and move on


 /*
        1- Create the wait object
        2- pass the webElement / locator in the ExpectedConditions. whatever method you need
         */

//      1- Create the wait object
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(10)). // max time out
                        pollingEvery(Duration.ofSeconds(2)). // poll every 2 seconds (time - interval between every check)
                        withMessage("Ignore the No Such Element Exception"). // OPTIONAL message
                        ignoring(NoSuchElementException.class); // OPTIONAL
//      Rest is the same as EXPLICT WAIT
//      2. pass the webElement / locator in the ExpectedConditions. whatever method you need

//        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Start']")));

//      With REUSABLE METHOD
        WebElement successMessage = fluentWait("//div[@id='finish']//h4", 10, 2);


//    Then verify the ‘Hello World!’ Shows up on the screen
        Assertions.assertTrue(successMessage.getText().contains("Hello World!"));

    }
}
