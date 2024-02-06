package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day11_FileUpload extends TestBase {


    @Test
    public void fileUploadTest() {


//    When user goes to
//    https://testpages.herokuapp.com/styled/file-upload-test.html
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");

        //First we need to handle the desktop pop-up because selenium cant deal with Desktop applications directly
        String pathOfFile = System.getProperty("user.home") + "/Downloads/AAH_2023.jpg"; // Dynamic way of declaring the path of the file

        // Now we need to locate the webElement
        WebElement chooseFileButton = driver.findElement(By.id("fileinput"));

        //    Then user selects an image from the desktop
        chooseFileButton.sendKeys(pathOfFile); // provide the path of the image where it is uploaded from

        //Choose the type of image
        driver.findElement(By.id("itsanimage")).click();
        waitFor(2);

//    And click on the upload button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        waitFor(2);

//    Then verify the message ‘You uploaded a file. This is the result.’ is displayed
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='explanation']//p")).
                getText().contains("You uploaded a file. This is the result."));

    }

}
