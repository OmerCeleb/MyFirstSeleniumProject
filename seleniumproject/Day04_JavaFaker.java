package com.myfirstproject;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class Day04_JavaFaker {

    /*
    Java Faker class is used for fake data

    Intvw Q: Where do you get your test data from?
    - BA (They write the acceptance criteria)
    - Test Lead
    - Manual tester
    - Developer
    - Database Call
    - API calls
    - Most commonly Java Faker class is used for test data (if company allows)
        it generate data randomly

     */

    @Test
    public void javaFakerTest() {
        Faker faker = new Faker();

        //First name
        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        //Last name
        String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);

        System.out.println("funnyName = " + faker.funnyName().name());
        //title
        System.out.println("title = " + faker.name().title());

        //city
        System.out.println(faker.address().city());
        //State
        System.out.println(faker.address().state());
        //Full adress
        System.out.println(faker.address().fullAddress());

        //Phone number
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.phoneNumber().phoneNumber());

        //Email
        System.out.println(faker.internet().emailAddress());

        // Random digits
        System.out.println(faker.number().digits(5));
        System.out.println(faker.number().numberBetween(50, 12));

        System.out.println(faker.internet().image());
        System.out.println(faker.internet().avatar());

    }
}
