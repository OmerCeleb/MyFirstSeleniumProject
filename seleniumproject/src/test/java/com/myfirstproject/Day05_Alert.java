package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day05_Alert extends TestBase {

//    Go to https://testcenter.techproeducation.com/index.php?page=javascript-alerts
//    acceptAlert() => click on the first alert, verify the text "I am a JS Alert"
//    click OK
//    and Verify "You successfully clicked an alert"
//    dismissAlert()=> click on the second alert, verify text "I am a JS Confirm"
//    click cancel
//    and Verify "You clicked: Cancel"
//    sendKeysAlert()=> click on the third alert, verify text "I am a JS prompt",
//    type "Hello World", click OK
//    and Verify "You entered: Hello World"


    @Test
    public void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //    acceptAlert() => click on the first alert, verify the text "I am a JS Alert"
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click(); //  button is webElement so we locate it and tell the driver to click on it
        //    the window pops up... which is an alert... we can NOT locate pop up window (alert) so we need to handle it
        //    click OK
        driver.switchTo().alert().accept();
        //    and Verify "You successfully clicked an alert"
        WebElement result = driver.findElement(By.id("result"));
        assertTrue(result.getText().contains("You successfully clicked an alert"));


    }

    @Test
    public void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//    dismissAlert()=> click on the second alert, verify text "I am a JS Confirm"
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();// clicks on the second button
//      At this point, we see an ALERT on the page,  we can NOT locate it, we have to handle it by switch to method
//    click cancel
        driver.switchTo().alert().dismiss();
//    and Verify "You clicked: Cancel"
        assertTrue(driver.findElement(By.id("result")).getText().contains("You clicked: Cancel"));
    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//    sendKeysAlert()=> click on the third alert, verify text "I am a JS prompt",
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();// clicks on the third button
//    type "Hello World", click OK
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();
//    and Verify "You entered: Hello World"
        assertTrue(driver.findElement(By.id("result")).getText().contains("You entered: Hello World"));
    }


}
