package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day09_Actions1 extends TestBase {

    @Test
    public void hoverOverTest() throws InterruptedException {
//        Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(6000);
        driver.navigate().refresh(); // This will resolve the captcha issue (hopefully)

//        When user click on "Account" link
//        We can't see the "Account" link unless we hover over "Account & List" option
//        So we need to create actions object
//        Step 1:
        Actions actions = new Actions(driver);
//        Step 2: Find the element first and then use moveToElement() from actions class
        WebElement accountListTab = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountListTab).perform();  // moveToElement() makes the driver hover over the given element
        Thread.sleep(2000);
//        Now we can see "Account" link on the dropdown
        WebElement accountOption =  driver.findElement(By.linkText("Account"));
//        accountOption.click(); // Normal way
        actions.click(accountOption).perform();  // Alternative if normal click() doesn't work

//        Then verify the page title contains "Your account"
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getTitle().contains("Your Account"));
//        Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));
        actions.moveToElement(amazonMusic).perform();  // moveToElement() will find the element where ever it is on the page
//        Click on it
//        amazonMusic.click();  /// Normal way
        actions.click(amazonMusic).perform();
//        Then verify Amazon Music page is displayed
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getCurrentUrl().contains("music"));
//        Scroll the page up and down
        actions.sendKeys(Keys.PAGE_DOWN).perform();  // scrolls down
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();  // scrolls down
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();  // scrolls down
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();  // scrolls down
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();  // scrolls down
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();  // scrolls down
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();  // scrolls down

        Thread.sleep(2000);

        actions.sendKeys(Keys.PAGE_UP).perform(); // scrolls up
        actions.sendKeys(Keys.PAGE_UP).perform(); // scrolls up

//        we can also create a chain of functions and it is recommended to use build()
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();



    }
}