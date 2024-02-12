package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Day13_CaptureScreenshot_EntirePage extends TestBase {

    @Test
    public void autoComplateTest() throws InterruptedException {

        // Given is on https://testcenter.techproeducation.com/index.php? page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?%20page=autocomplete");
        captureScreenShotOfEntirePage();

        // When user type "uni" in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        waitFor(2);
        captureScreenShotOfEntirePage();

        // And select the United Kingdom from the suggestion
        driver.findElement(By.xpath("//*[@id='myCountryautocomplete-list']/div[2]")).click();
        waitFor(2);

        // And click on submit button
        driver.findElement(By.xpath("/html/body/main/div/div[1]/div/form/input")).click();
        waitFor(2);

        // Then verify the result contains United Kingdom
        Assertions.assertTrue(driver.findElement(By.id("result")).isDisplayed());
        captureScreenShotOfEntirePage();

    }

}
