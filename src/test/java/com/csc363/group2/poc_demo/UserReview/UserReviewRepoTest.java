package com.csc363.group2.poc_demo.UserReview;

import com.csc363.group2.poc_demo.ClassController.ClassController;
import com.csc363.group2.poc_demo.ClassService.ClassService;
import com.csc363.group2.poc_demo.appuser.AppUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@WebMvcTest(ClassController.class)
class UserReviewRepoTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserReviewRepo reviewRepo;

    @MockBean
    ClassService classService;

    @MockBean
    AppUserService appUserService;

    @MockBean
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Test
    void getUserReviewEntitiesByUserReviewDepartmentAndUserReviewCourseNumber() {
        assertEquals(new ArrayList<>(),reviewRepo.getUserReviewEntitiesByUserReviewDepartmentAndUserReviewCourseNumber("CSC",394));
    }
}