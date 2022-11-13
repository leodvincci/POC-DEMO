package com.csc363.group2.poc_demo.Services;

import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.ClassRepo.ClassRepository;
import com.csc363.group2.poc_demo.ClassService.ClassService;
import com.csc363.group2.poc_demo.Repos.UserRepository;
import com.csc363.group2.poc_demo.UserReview.UserReviewRepo;
import com.csc363.group2.poc_demo.UserReview.UserReviewService;
import com.csc363.group2.poc_demo.appuser.AppUser;
import com.csc363.group2.poc_demo.appuser.AppUserRepository;
import com.csc363.group2.poc_demo.appuser.AppUserService;
import com.csc363.group2.poc_demo.registration.token.ConfirmationToken;
import com.csc363.group2.poc_demo.registration.token.ConfirmationTokenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServicesTest {


    UserService userService;


    @Mock
    UserRepository userRepository;

    @Mock
    ConfirmationTokenRepository confirmationTokenRepository;




    @Mock
    AppUserRepository appUserRepository;


    @Mock
    AppUserService appUserService;

    private ClassEntity classEntity;





    private AutoCloseable autoCloseable;


    @BeforeEach
    void setUp() throws Exception{
        autoCloseable = MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    void willGetListOfUsers(){
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        appUser.setFirstName("Abrahim");
        appUser.setFirstName("Hussain");
        appUser.setEmail("abrahim@gmail.com");
        appUser.setPassword("1234");
        appUser.setEnabled(true);
        appUser.setLocked(false);
        userRepository.save(appUser);

        userService.getListofUsers();
        verify(userRepository).findAll();


    }





}