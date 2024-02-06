package com.myfirstproject;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day10_FileExist {

    @Test
    public void fileExist() {

        // Pick a file on your desktop
        String path = System.getProperty("user.home") + "Skrivbord/CMYX4881.JPG";
        System.out.println("path = " + path);

        // And verify if that file exists on your computer or not
        boolean isFileExist = Files.exists(Paths.get(path));
        System.out.println("isFileExist = " + isFileExist);


    }


}
