package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyURLTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // Navigate to amazon homepage
        driver.get("https://www.amazon.com");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);

        // Verify if google homepage url is "https://www.amazon.com.tr/"
        String currentURL = driver.getCurrentUrl();
        //  System.out.println("currentURL " + currentURL);

        // Validation
        if (currentURL.contains("https://Zw.amazon.com")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }


        // Close the windows
        driver.quit();

    }
}
