package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyTitleTest {

    public static void main(String[] args) throws InterruptedException {

        //Set up
        //  WebDriverManager.chromedriver().setup(); No need for this anymore
        WebDriver driver = new ChromeDriver();


        // Navigate to amazon homepage
        driver.get("https://www.amazon.com.tr/");
        Thread.sleep(1000);
        driver.manage().window().maximize(); // opens the whole page
        driver.navigate().refresh();        // we are refreshing it here to get rid of captcha (but it does not work all the time)
        Thread.sleep(1000);


        // Verify if page title is Amazon.com Spend less. Smile more
        String actualTitle = driver.getTitle(); // returnes title of the current page
        System.out.println("Actual title = " + actualTitle);

        if (actualTitle.contains("Amazon")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test failed");
            System.out.println("Actual title: " + actualTitle + "expected title: Amazon.com");
        }

        //Close
        driver.quit();


        /*
        QUOTE OF THE DAY:

        - Testers don't write codes to PASS the test
        - Testers write codes to FIND THE BUG / DEFECT


        NOTES:
        If my test case fails, I as a tester should NOT fix the code to see PASS,
        Steps:
        1. Communicate with the Team Lead /  Test Lead / BA to check if that is a requirement issue
            if it is requirement issue should fix the AC and then update the backlog / document.
        2. If it is  actual bug then I should communicate with my team and see if I need to raise bug ticket
            or create new user story.

         */
    }
}
