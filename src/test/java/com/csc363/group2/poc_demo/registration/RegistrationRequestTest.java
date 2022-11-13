package com.csc363.group2.poc_demo.registration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationRequestTest {



    @Test
    void getFirstName() {
        RegistrationRequest registrationRequest = new RegistrationRequest("Abrahim",
                "Hussain",
                "abrahim@gmail.com",
                "1234");

        assertEquals("Abrahim", registrationRequest.getFirstName());
    }

    @Test
    void getLastName() {
        RegistrationRequest registrationRequest = new RegistrationRequest("Abrahim",
                "Hussain",
                "abrahim@gmail.com",
                "1234");

        assertEquals("Hussain", registrationRequest.getLastName());
    }

    @Test
    void getEmail() {
        RegistrationRequest registrationRequest = new RegistrationRequest("Abrahim",
                "Hussain",
                "abrahim@gmail.com",
                "1234");

        assertEquals("abrahim@gmail.com", registrationRequest.getEmail());
    }

    @Test
    void getPassword() {
        RegistrationRequest registrationRequest = new RegistrationRequest("Abrahim",
                "Hussain",
                "abrahim@gmail.com",
                "1234");

        assertEquals("1234" , registrationRequest.getPassword());
    }


}