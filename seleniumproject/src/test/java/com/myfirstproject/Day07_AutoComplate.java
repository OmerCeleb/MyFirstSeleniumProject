package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Day07_AutoComplate extends TestBase {

    @Test
    public void autoComplateTest() throws InterruptedException {

        // Given is on https://testcenter.techproeducation.com/index.php? page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?%20page=autocomplete");

        // When user type "uni" in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        Thread.sleep(1000);
        // And select the United Kingdom from the suggestion
        driver.findElement(By.xpath("//div[@div='myCountryautoComplete-list']//div[.='United Kingdom']")).click();
        Thread.sleep(1000);

        // And click on submit button
        driver.findElement(By.xpath("//input[@type='button'")).click();
        Thread.sleep(1000);

        // Then verify the result contains United Kingdom
        Assertions.assertTrue(driver.findElement(By.id("result")).isSelected());




    }

}
