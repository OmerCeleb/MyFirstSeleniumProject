package com.myfirstproject;

import com.myfirstproject.utilities.LoggerUtils;
import org.junit.jupiter.api.Test;

public class Day13_Log4j {

    @Test
    public void test() {
        System.out.println("This is how we print stuff on the console");

        LoggerUtils.info("This is how we use Logger to log.");

        LoggerUtils.fatal("This is to show if some step in the code is not working");

        

    }

}
