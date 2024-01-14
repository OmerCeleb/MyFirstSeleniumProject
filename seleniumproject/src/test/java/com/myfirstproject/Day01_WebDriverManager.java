package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_WebDriverManager {

    public static void main(String[] args) {

        /*
        1. Add a WebDriverManager repository from https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.6.2
        and get the latest version, paste it Inside dependencies tag.
        2. Reload the project.
        3. Use WebDriverManager class to set up. (latest way)
         */

        // 1. Set up
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.edgedriver().setup();

        // 2. Create the driver
        WebDriver driver = new ChromeDriver();

        // 3. Now that driver is ready, automate the function that we want to perform
        driver.get("https://www.google.com");


    }

}
