package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Day07_Authentication extends TestBase {

    @Test
    public void authentication() {
        // Username : admin
        // password : admin
        // url : the-internet.herokuapp.com/basic_auth

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Verify if authentication is succesful or not
        Assertions.assertTrue(driver.findElement(By.xpath("//p")).getText().contains("Congratulations"));


    }
}
