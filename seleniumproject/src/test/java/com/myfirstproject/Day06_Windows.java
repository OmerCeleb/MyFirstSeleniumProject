package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day06_Windows extends TestBase {

    @Test
    public void windowsTest() throws InterruptedException {

        // Go to "https://the-internet.herokuapp.com/windows"
        driver.get("https://the-internet.herokuapp.com/windows");
        // Assert if the Windows 1 title equals "The Internet"
        assertTrue(driver.getTitle().equals("The Internet"));
        Thread.sleep(2000);

        // Click on the link
        driver.findElement(By.linkText("Click Here")).click();
        // let get the handle of this window first
        String window1Handle = driver.getWindowHandle();
        System.out.println("window1Handle = " + window1Handle);

        // New window opened but the driver is still on the previous window,
        // so we have to switch first
        // driver.switchTo().window();  at this point we don't have hash code for the new window so we cant provide that in window()
        // so we use getWindowsHandles() to get all hashcode and them we loop through it
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("allWindowHandles = " + allWindowHandles);  // returns all window handles / hashcode
        // Use a for each loop to get the second window handle

        for (String eachHandle : allWindowHandles) {
            if (!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle); // at this point, driver will switch to 2nd window
            }
        }

        // Assert if the window 2 title equals "New Window"
        assertTrue(driver.getTitle().equals("New Window"));

        // Now that driver is on second window, we can get its handle too
        String window2Handle = driver.getWindowHandle();
        System.out.println("window2Handle = " + window2Handle);

        // Switch back to window 1 title and assert if URL contains "windows"
        driver.switchTo().window(window1Handle);
        assertTrue(driver.getCurrentUrl().contains("windows"));

        // And assert if the URL doesn't contain "new"
        assertTrue(!driver.getCurrentUrl().contains("new")); // OR
        // assertFalse(driver.getCurrentUrl().contains("new"));

        // Switch back to window 2
        driver.switchTo().window(window2Handle);
        Thread.sleep(2000);


        // Switch back to window 1
        driver.switchTo().window(window1Handle);




    }

}
