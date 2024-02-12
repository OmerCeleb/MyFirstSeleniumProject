package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day13_CaptureScreenshor_GivenElement extends TestBase {

    @Test
    public void screenshotGivenElementTest() {

        driver.get("https://www.google.se/?hl=sv");

        WebElement image = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img")); // //*[@class='k1zIA rSk4se']//img
        waitFor(2);
        captureScreenShotOfElement(image);

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Iphone 15");
        captureScreenShotOfElement(searchBox);



    }
}
