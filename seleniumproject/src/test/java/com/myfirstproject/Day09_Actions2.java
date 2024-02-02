package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day09_Actions2 extends TestBase {

    @Test
    public void actionsTest() throws InterruptedException {

//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(2000);

        // We found an iframe on the page, so we need to switch to it first
        //driver.switchTo().frame(0);
        switchIframeByIndex(0); // REUSABLE Method

//        And user moves the target element(Drag me to my target) in to destination(Drop here)
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));


        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();


    }


    @Test
    public void actionsTest2() throws InterruptedException {

//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(2000);

        // We found an iframe on the page, so we need to switch to it first
        //driver.switchTo().frame(0);
        switchIframeByIndex(0); // REUSABLE Method

//        And user moves the target element(Drag me to my target) in to destination(Drop here)
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));


        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        // actions.dragAndDrop(source, target).perform();
        // actions.clickAndHold(source).moveToElement(target).build().perform();
        // actions.clickAndHold(source).moveToElement(target).release().build().perform();

        actions.dragAndDropBy(source, 207, 268).perform(); // this method works with the given x,y coordinates

    }


}