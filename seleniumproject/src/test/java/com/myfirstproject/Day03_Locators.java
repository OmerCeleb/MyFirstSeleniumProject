package com.myfirstproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day03_Locators {

    WebDriver driver;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Thread.sleep(2000); // Hard Java wait ==> it will for 2 seconds NO matter what
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // Implicit wait Recommended because it will as long as it need to.
        // if the page is loaded earlier and element is available before the given time,
        // driver will not wait any more and perform the given function

    }

    @Test
    public void loginTest() {

        // When user goes to: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // And enter username
        driver.findElement(By.name("username")).sendKeys("Admin");
        // And enter password
        driver.findElement(By.name("password")).sendKeys("admin123");
        // And clock on submit button
        driver.findElement(By.tagName("button")).click();
        // Then verify the login is successful

        /*
        1.Way of verifications - by using URL

        https://opensource-demo.orangehrmlive.com/web/index.php/auth/login // Before login
        https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index // After login is succesfully

            if current URl contains the word "dashboard" then it means login is successful
            if current URl contains the word "auth" then it means login is not successful

        2.Way of verifications - by using core element
        We can locate any core element like profile pic or dashboard and verify if it is displayed or

         */
        // Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        //OR
        //Assertions.assertFalse(driver.getCurrentUrl().contains("auth"));
        //OR
        Assertions.assertTrue(driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed());

        // Then logout the application
        driver.findElement(By.className("oxd-userdropdown-img")).click(); // clicks on the profile, so we can see the logout in dropdown menu
        driver.findElement(By.linkText("Logout")).click(); // linkText locator works with exact match

        driver.findElement(By.partialLinkText("Logout")).click(); //this locator works with part of the text (but it ise case-sensitive)

        // Then verify the logout is successful
        Assertions.assertTrue(driver.getCurrentUrl().contains("auth"));


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
