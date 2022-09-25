package com.csc363.group2.poc_demo.Services;

import com.csc363.group2.poc_demo.Repos.UserRepository;
import com.csc363.group2.poc_demo.appuser.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<AppUser> getListofUsers(){
        return userRepository.findAll();
    }

}
