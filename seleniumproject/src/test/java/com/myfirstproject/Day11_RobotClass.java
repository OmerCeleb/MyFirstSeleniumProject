package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Day11_RobotClass extends TestBase {

    @Test
    public void robotTest() throws AWTException {


        //https://testpages.herokuapp.com/styled/file-upload-test.html
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");

        //First we need to handle the desktop pop-up because selenium cant deal with Desktop applications directly
        String pathOfFile = System.getProperty("user.home") + "/Skrivbord/CMYX4881.JPG"; // Dynamic way of declaring the path of the file

        // Now we need to locate the webElement
        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@type='file']"));
      //  chooseFileButton.click(); Selenium click dont work
        clickByJS(chooseFileButton);

        // Then user selects an image from the desktop


        // ROBOT CLASS
        StringSelection ss = new StringSelection(pathOfFile);  // declare the pathOfFIle on the clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();

        // Pressing control C => selecting
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);


        // Pressing control V (pasting)
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        // Press enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //    And click on the upload button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        waitFor(2);

        //    Then verify the message ‘You uploaded a file. This is the result.’ is displayed
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='explanation']//p")).
                getText().contains("You uploaded a file. This is the result."));


    }
}


