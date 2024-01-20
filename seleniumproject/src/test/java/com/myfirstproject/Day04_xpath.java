package com.myfirstproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Day04_xpath {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver(); // set up driver
        driver.manage().window().maximize(); // maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implicit wait

    }

    @AfterEach // runs after each test method
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        // When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //And enter usernam
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");
        Thread.sleep(2000);

        //And enter pasword
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        Thread.sleep(2000);

        //And click the login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        //Then verify the login is succesful
        // Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        //OR
        //Assertions.assertFalse(driver.getCurrentUrl().contains("auth"));
        //OR
        Assertions.assertTrue(driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed());


        //Get all items in the dropdown list
        List<WebElement> dropdownList = driver.findElements(By.xpath("//ul[@role='menu']"));
        System.out.println(dropdownList);
        Thread.sleep(3000);

        for (WebElement w : dropdownList) {
            System.out.println(w.getText());

        }

        // Then logout the application
        driver.findElement(By.className("oxd-userdropdown-img")).click(); // clicks on the profile, so we can see the logout in dropdown menu

        driver.findElement(By.partialLinkText("Logout")).click(); //this locator works with part of the text (but it ise case-sensitive)

        // Then verify the logout is successful
        Assertions.assertTrue(driver.getCurrentUrl().contains("auth"));


    }


}
