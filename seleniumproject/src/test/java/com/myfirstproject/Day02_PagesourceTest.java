package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_PagesourceTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //Navigate to amazon home page
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);
        driver.navigate().refresh();

        //get the page source code
        String pageSource = driver.getPageSource();
        //     System.out.println(pageSource);

        //Validation
        if (pageSource.contains("Registery")) {
            System.out.println("PASS");

        } else {
            System.out.println("FAIL. There is no such word on the page");
        }

        driver.quit();
    }
}
