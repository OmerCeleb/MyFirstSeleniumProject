package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day12_NoSuchElementException extends TestBase {

    @Test
    public void noSuchElementException() {
        driver.get("https://www.amazon.com");
        waitFor(2);
        driver.navigate().refresh();

//        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));  // correct locator
//        searchBox.sendKeys("porcelain teapot", Keys.ENTER);


        WebElement searchBox = driver.findElement(By.id("two  tabsearchtextbox"));  // WRONG locator
        searchBox.sendKeys("porcelain teapot", Keys.ENTER);

//      This will throw NoSuchElement Exception because element cant be located


    }

    @Test
    public void test2() throws InterruptedException {

//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(2000);


//        And user moves the target element(Drag me to my target) in to destination(Drop here)
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
//      No suchElementException because elements are inside the iFrame and driver can't locate them


        Actions actions = new Actions(driver);
        Thread.sleep(2000);

        actions.dragAndDrop(source, target).perform();

    }
}
