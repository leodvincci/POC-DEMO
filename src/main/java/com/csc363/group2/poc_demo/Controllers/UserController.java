package com.csc363.group2.poc_demo.Controllers;

import com.csc363.group2.poc_demo.Services.UserService;
import com.csc363.group2.poc_demo.appuser.AppUser;
import com.csc363.group2.poc_demo.appuser.AppUserModelBody;
import com.csc363.group2.poc_demo.appuser.AppUserService;
import com.csc363.group2.poc_demo.security.UpdatePasswordBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @Autowired
    public AppUserService appUserService;





    @GetMapping("/allusers")
    public List<AppUser> getAllUsers(){
        return userService.getListofUsers();
    }


    @GetMapping("/removeuser")
    @ResponseBody
    public void deleteAllUsers(@RequestParam Long id){
        userService.deleteUser(id);

    }

    @PostMapping("api/v1/resetpassword")
    @ResponseBody
    public void resetUserPassword(@RequestBody UpdatePasswordBody updatePasswordBody){
        System.out.println("Password has been reset for " + updatePasswordBody.getEmail());
        System.out.println("Password:" + updatePasswordBody.getPassword());
        userService.setNewPassword(updatePasswordBody.getEmail(), appUserService.generateNewPassword(updatePasswordBody.getPassword()));

    }


    @PostMapping("api/v1/updateuserinfo")
    @ResponseBody
    public void updateUserInfo(@RequestBody AppUserModelBody appUserModelBody){
        userService.updateUser(appUserModelBody.getFirstName(),appUserModelBody.getLastName(),appUserModelBody.getEmail(),appUserModelBody.getPassword(),appUserModelBody.getRole());
    }

}
