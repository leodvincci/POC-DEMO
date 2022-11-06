package com.csc363.group2.poc_demo.appuser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    AppUser appUser = new AppUser("Leo","Penrose","leodpenrose@gmail.com","Password123",AppUserRole.ADMIN);

    @Test
    void getPassword() {
        assertEquals("Password123",appUser.getPassword());
    }

    @Test
    void getUsername() {
        assertEquals("leodpenrose@gmail.com",appUser.getEmail());
    }

    @Test
    void getFirstName() {
        assertEquals("Leo",appUser.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Penrose",appUser.getLastName());
    }

    @Test
    void setPassword() {
        appUser.setPassword("NotMyPass");
        assertEquals("NotMyPass",appUser.getPassword());

    }


    @Test
    void getEmail() {
        assertEquals("leodpenrose@gmail.com",appUser.getEmail());
    }

    @Test
    void getAppUserRole() {
        assertEquals(AppUserRole.ADMIN,appUser.getAppUserRole());
    }

    @Test
    void setFirstName() {
        appUser.setFirstName("Bob");
        assertEquals("Bob",appUser.getFirstName());
    }

    @Test
    void setLastName() {
        appUser.setLastName("Rosepen");
        assertEquals("Rosepen",appUser.getLastName());

    }

    @Test
    void setEmail() {
        appUser.setEmail("notMyEmail@hotmail.com");
        assertEquals("notMyEmail@hotmail.com",appUser.getEmail());

    }

    @Test
    void setAppUserRole() {
        appUser.setAppUserRole(AppUserRole.USER);
        assertEquals(AppUserRole.USER,appUser.getAppUserRole());
    }
}