package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day10_FileDownload extends TestBase {

    @Test
    public void fileDownloadTest() {

        // Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");

        //Download Rectangle.png file
        //Locate the element first
        driver.findElement(By.linkText("AAH_2023.jpg")).click();
        // To let the download complete, we add some time
        waitFor(5); // Reusable method
        String pathOfDownloadedFile = System.getProperty("user.home") + "/Downloads/AAH_2023.jpg";
        System.out.println("pathOfDownloadedFile = " + pathOfDownloadedFile);

        //Then verify if the file downloaded successfully
        Assertions.assertTrue(Files.exists(Paths.get(pathOfDownloadedFile)));

        // if test fails, we get the failure message
        Assertions.assertTrue(Files.exists(Paths.get(pathOfDownloadedFile)),"Download failed " + pathOfDownloadedFile);

    }

}
