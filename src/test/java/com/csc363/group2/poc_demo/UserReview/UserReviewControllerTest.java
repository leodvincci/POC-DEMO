package com.csc363.group2.poc_demo.UserReview;

import com.csc363.group2.poc_demo.ClassController.ClassController;
import com.csc363.group2.poc_demo.ClassService.ClassService;
import com.csc363.group2.poc_demo.appuser.AppUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserReviewController.class)
class UserReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserReviewService userReviewService;



    @MockBean
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @MockBean
    AppUserService appUserService;

    @MockBean
    ClassService classService;

    @Test
    void calGPA() {
    }

    @Test
    void deleteReviewByEmailCourseDept() {
    }

}