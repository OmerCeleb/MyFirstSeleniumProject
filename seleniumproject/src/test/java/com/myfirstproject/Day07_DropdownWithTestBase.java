package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Day07_DropdownWithTestBase extends TestBase {

    /*
    - Dropdown is a list of webElements
    - How to select from a dropdown?
        We can use 3 ways to select from a dropdown; byIndex, byValue and byVisibleText
    - How to get selected option from a dropdown? (For Verification purpose)
    - We use getFirstSelectedOption() method
     */

    @Test
    public void dropdpwnTest() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //  Chose your birthdate 1997-11-21
        //Year
        // Step 1: locate the dropdown
        WebElement year = driver.findElement(By.id("year"));
        // Step 2: Create object from Select Classed assign the webElement to it
        Select selectYear = new Select(year);
        // Step 3: Now we have the select object, now we can interact with the dropdown
        selectYear.selectByVisibleText("1997"); // Selecting the year by visible text

        //Mounth
        WebElement month = driver.findElement(By.cssSelector("#month"));
        Select selectMonth = new Select(month);
//        selectMonth.selectByValue("10"); // Selecting month of November by its valuse

        // Selecting month dropdown using REUSABLE METHODS from TestBase (use any one of the following)
        dropDownSelectByIndex(driver.findElement(By.id("month")), 6);   // locator , index
        dropDownSelectByIndex(driver.findElement(By.cssSelector("#month")), 6);   // css , index
        dropDownSelectByIndex("//select[@id='month']", 6); // xpath, index


        //Day
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select selectDay = new Select(day);
        selectDay.selectByIndex(20);


        //Assert that year 1997 is selected
        WebElement selectedYear = selectYear.getFirstSelectedOption(); // returns the option that we selected (sent for year)
        //System.out.println("selectedYear = " + selectedYear.getText());
        assertTrue(selectedYear.getText().contains("1997")); // verifying if the selected year as the same as expected

        // Get all months from the dropdown and assert that "October" is an option in the months

        List<WebElement> allMonths = selectMonth.getOptions(); // returns all webElements in the dropdown list

        boolean flag = false;  // declare a boolean variable to use for assertion
        for (WebElement w : allMonths) {
            System.out.println(w.getText());

            if (w.getText().contains("October")) {
                flag = true;
            }

        }
        assertTrue(flag);
    }


}
