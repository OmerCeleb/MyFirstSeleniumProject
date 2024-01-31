package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day08_Cookies extends TestBase {

    @Test
    public void cookieTest() throws InterruptedException {
//        Go to amazon  https://www.amazon.com/
        driver.get("https://www.amazon.se");
        Thread.sleep(1000);
        driver.navigate().refresh(); // Refreshing here to get rid of captcha

//        Find the total number of cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println("Total Cookies: " + allCookies.size());
        System.out.println("=======================================");

//        Print all the cookies
        for (Cookie eachCookie : allCookies) {
            System.out.println("Each Cookie = " + eachCookie);
            System.out.println("Each Cookie Name = " + eachCookie.getName());
            System.out.println("Each Cookie Value = " + eachCookie.getValue());

        }
        System.out.println("==============================");


//        Get the cookies by their name
        System.out.println("Cookie by name: " + driver.manage().getCookieNamed("csm-sid"));
        System.out.println("==============================");

//        Add new cookie
        Cookie myFavCookie = new Cookie("myCookie", "Login-detail200020");
        driver.manage().addCookie(myFavCookie);
        Thread.sleep(1000);
        for (Cookie each : driver.manage().getCookies()) {
            System.out.println("All Cookies = " + each);
        }

//        Delete all cookies
        driver.manage().deleteCookieNamed(myFavCookie.toString()); // This will delete one given cookie
        driver.manage().deleteAllCookies();
        Thread.sleep(1000);
        System.out.println("After deleting all cookies, there are " + driver.manage().getCookies().size() + " cookies left");



    }

}
