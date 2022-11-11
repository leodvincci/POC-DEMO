package com.csc363.group2.poc_demo.Services;

import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.Repos.UserRepository;
import com.csc363.group2.poc_demo.appuser.AppUser;
import com.csc363.group2.poc_demo.appuser.AppUserRepository;
import com.csc363.group2.poc_demo.appuser.AppUserRole;
import com.csc363.group2.poc_demo.appuser.AppUserService;
import com.csc363.group2.poc_demo.registration.token.ConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUserService appUserService;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    public List<AppUser> getListofUsers(){
        return userRepository.findAll();
    }

    public void  deleteUser(Long id){
        confirmationTokenRepository.deleteById(id);
        userRepository.deleteById(id);
    }

    public AppUser getUsersSavedCourses(String userEmailAddress){

        return userRepository.getAppUserByEmail(userEmailAddress);

    }


    public void setNewPassword(String email, String password){
       Optional<AppUser> user = appUserRepository.findByEmail(email);
        user.get().setPassword(password);
        System.out.println("THE PASSWORD: " + user.get().getPassword());
        appUserService.saveTheUser(user.get());

    }

    public void updateUser(String firstName, String lastName, String email, String password, AppUserRole role){
        Optional<AppUser> user = appUserRepository.findByEmail(email);
        user.get().setPassword(password);
        user.get().setFirstName(firstName);
        user.get().setLastName(lastName);
        user.get().setAppUserRole(role);
        System.out.println("User Info Has Been Updated" + user);
        appUserService.saveTheUser(user.get());
    }

}
