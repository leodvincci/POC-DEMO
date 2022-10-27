package com.csc363.group2.poc_demo.Controllers;

import com.csc363.group2.poc_demo.Repos.UserRepository;
import com.csc363.group2.poc_demo.Services.UserService;
import com.csc363.group2.poc_demo.appuser.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    void whoAmItest(){
        AppUser appUser = new AppUser();
        appUser.setEmail("leodpenrose@gmail.com");
        assertEquals("leodpenrose@gmail.com",appUser.getEmail());
    }

}