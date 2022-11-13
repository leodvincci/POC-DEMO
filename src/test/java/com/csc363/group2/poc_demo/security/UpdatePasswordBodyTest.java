package com.csc363.group2.poc_demo.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdatePasswordBodyTest {

    @Test
    void getEmail() {
        UpdatePasswordBody updatePasswordBody = new UpdatePasswordBody("abrahim@gmail.com", "1234");
        assertEquals("abrahim@gmail.com", updatePasswordBody.getEmail());
    }

    @Test
    void getPassword() {
        UpdatePasswordBody updatePasswordBody = new UpdatePasswordBody("abrahim@gmail.com", "1234");
        assertEquals("1234", updatePasswordBody.getPassword());
    }
}