package com.csc363.group2.poc_demo.Controllers;

import com.csc363.group2.poc_demo.Services.UserService;
import com.csc363.group2.poc_demo.appuser.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/allusers")
    public List<AppUser> getAllUsers(){
        return userService.getListofUsers();
    }

}
