package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day10_JSExecutor extends TestBase {

    @Test
    public void jsExecutorTest() throws InterruptedException {


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
        WebElement accountOption = driver.findElement(By.linkText("Account"));
//        accountOption.click(); // Normal way
//        actions.click(accountOption).perform();  // Alternative if normal click() doesn't work
        // if both of above click() dont work (happens rarely), we can use JSExecutor method to click

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", accountOption, accountListTab);  // arguments[0] has index 0, which means click on the first webElement

//        Then verify the page title contains "Your account"
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getTitle().contains("Your Account"));

//        Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));
        //       actions.moveToElement(amazonMusic).perform();  // moveToElement() will find the element where ever it is on the page
        js.executeScript("arguments[0].scrollIntoView(true);", amazonMusic);  // scrolling to that webElement

//        Click on it
//        amazonMusic.click();  /// Normal way
//        actions.click(amazonMusic).perform();
        js.executeScript("arguments[0].click();", amazonMusic);

//        Scroll the page up and down
        js.executeScript("window.scrollTo(0, 250);");  // Scroll down
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0, -250);");  // Scroll up
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");  // Scroll down
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");  // Scroll up

//     Locate the search input at music page using JSExecutor method
        waitFor(2);
        WebElement searchInput = locateElementByJS("navbarSearchInput"); // Using Reusable method

//      Send the text 'POP' to search input
//        searchInput.sendKeys("POP"); // normal way


        setValueByJS(searchInput, "POP"); // Using Reusable method for js Executor
        // Get the value from the search input using JS Executor
        String inputValue = getValueByJS("navbarSearchInput");

        // Assert the value sent is the same
        Assertions.assertTrue(inputValue.contains("POP"));


    }
}