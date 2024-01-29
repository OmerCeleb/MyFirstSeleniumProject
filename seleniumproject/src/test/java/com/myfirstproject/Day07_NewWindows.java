package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

import static org.junit.jupiter.api.Assertions.*;

public class Day07_NewWindows extends TestBase {

    public void newTabTest() throws InterruptedException {
        // Open the pages in 2 new windows and verify their TITLES => LinkedIn, Ebay
        // Open 2 new tabs and verify their TITLES => LinkedIn , Ebay

        // LinkedIn
        driver.get("https://www.linkedin.com");
        assertTrue(driver.getTitle().contains("LinkedIn"));
        Thread.sleep(3000);

        // Get the window handle
        String linkedInHandle = driver.getWindowHandle();


        // Ebay
        // I (as a QA) want to open a new tab for the second web page
        driver.switchTo().newWindow(WindowType.TAB);  // This makes the driver open a new tab
        driver.get("https://www.ebay.com");
        assertTrue(driver.getTitle().contains("eBay"));

        // Get the window handle
        String ebayHandle = driver.getWindowHandle();

        // Go back to LinkedIn page
        driver.switchTo().window(linkedInHandle);
        String linkedInURL = driver.getCurrentUrl();
        System.out.println("linkedInURL = " + linkedInURL);

        // Go to Ebay page
        driver.switchTo().window(ebayHandle);
        String ebayURL = driver.getCurrentUrl();
        System.out.println("ebayURL = " + ebayURL);

    }



    @Test
    public void newWindowsTest() throws InterruptedException {
        // Open the pages in 2 new windows and verify their TITLES => LinkedIn, Ebay
        // Open 2 new tabs and verify their TITLES => LinkedIn , Ebay

        // LinkedIn
        driver.get("https://www.linkedin.com");
        assertTrue(driver.getTitle().contains("LinkedIn"));
        Thread.sleep(3000);

        // Get the window handle
        String linkedInHandle = driver.getWindowHandle();


        // Ebay
        // I (as a QA) want to open a new tab for the second web page
        driver.switchTo().newWindow(WindowType.WINDOW);  // This makes the driver open a new tab
        driver.get("https://www.ebay.com");
        assertTrue(driver.getTitle().contains("eBay"));

        // Get the window handle
        String ebayHandle = driver.getWindowHandle();

        // Go back to LinkedIn page
        driver.switchTo().window(linkedInHandle);
        String linkedInURL = driver.getCurrentUrl();
        System.out.println("linkedInURL = " + linkedInURL);

        // Go to Ebay page
        driver.switchTo().window(ebayHandle);
        String ebayURL = driver.getCurrentUrl();
        System.out.println("ebayURL = " + ebayURL);

    }


}
