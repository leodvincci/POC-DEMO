package com.csc363.group2.poc_demo.appuser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppUserModelBodyTest {

    AppUserModelBody user = new AppUserModelBody(
            "Leo",
            "Penrose",
            "leodpenrose@gmail.com",
            "password123",
            AppUserRole.ADMIN
    );

    @Test
    void getFirstName() {
        assertEquals("Leo",user.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Penrose",user.getLastName());
    }

    @Test
    void getEmail() {
        assertEquals("leodpenrose@gmail.com",user.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals("password123",user.getPassword());

    }

    @Test
    void getRole() {
        assertEquals(AppUserRole.ADMIN,user.getRole());
    }
}