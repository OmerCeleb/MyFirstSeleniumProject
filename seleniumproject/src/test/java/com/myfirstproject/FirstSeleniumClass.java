package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {

    public static void main(String[] args) {

        // 1. Set the path of the driver
        System.setProperty("What is it", "Where it is");
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");



        // 2. Create the driver
        WebDriver driver = new ChromeDriver();




        // 3. Now that driver is ready, automate the function that we want to perform
        driver.get("https://www.amazon.com");
        


    }


}
