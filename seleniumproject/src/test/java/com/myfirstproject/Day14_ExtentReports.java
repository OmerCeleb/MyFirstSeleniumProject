package com.myfirstproject;

import com.myfirstproject.utilities.LoggerUtils;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;

public class Day14_ExtentReports extends TestBase {

    @Test
    public void extentReportTest() {

        // Examples of extentTest methods to see how they're used
        extentTest.info("Login should be active after registration ");
        extentTest.warning("Pay attention to the Login Button!!!");
        extentTest.fail("Login Button is not interactive");
        extentTest.skip("Registration is skipped for this test");
        extentTest.pass("Login is successful!!");

        // NOTE: These methods works just like System.out.println(); to log the information about a given step in the test case.


    }

    @Test
    public void extendReportTest2() throws IOException {

        LoggerUtils.info("Starting the test case for autocomplete functionality");

        extentTest
                .info("Navigating to the application home page").
                assignAuthor("Ömer, Sloane").
                assignDevice("Win").
                assignCategory("Smoke Test").
                addScreenCaptureFromPath(captureScreenShotOfEntirePageAsString());


        // Given is on https://testcenter.techproeducation.com/index.php? page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?%20page=autocomplete");
        extentTest.
                pass("User is on the home page").
                addScreenCaptureFromPath(captureScreenShotOfEntirePageAsString());


        // When user type "uni" in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        waitFor(2);

        extentTest.pass("User types uni in the search box ").
                addScreenCaptureFromPath(captureScreenShotOfEntirePageAsString());


        // And select the United Kingdom from the suggestion
        driver.findElement(By.xpath("//*[@id='myCountryautocomplete-list']/div[2]")).click();
        waitFor(2);
        extentTest.pass("United Kingdom is selected from the suggestions").
                addScreenCaptureFromPath(captureScreenShotOfEntirePageAsString());

        // And click on submit button
        driver.findElement(By.xpath("/html/body/main/div/div[1]/div/form/input")).click();
        waitFor(2);

        // Then verify the result contains United Kingdom
        Assertions.assertTrue(driver.findElement(By.id("result")).isDisplayed());
        extentTest.pass("result contains United Kingdom").
                addScreenCaptureFromPath(captureScreenShotOfEntirePageAsString());


        LoggerUtils.info("Test case passed.");

    }


}
