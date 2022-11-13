package com.csc363.group2.poc_demo.UserReview;

import com.csc363.group2.poc_demo.ClassController.ClassController;
import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.ClassService.ClassService;
import com.csc363.group2.poc_demo.appuser.AppUserService;
import org.h2.engine.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
class UserReviewServiceTest {


    UserReviewService userReviewService;

    @Mock
    UserReviewRepo userReviewRepo;

    private UserReviewEntity userReviewEntity;


    private AutoCloseable autoCloseable;


    @BeforeEach
    void setUp() throws Exception {
        autoCloseable = MockitoAnnotations.openMocks(this);
        userReviewService = new UserReviewService(userReviewRepo);
    }

    @Test
    void WillAddUserReview() {




        List<ClassEntity> classEntityList = new ArrayList<>();
        userReviewService.addUserReview("abrahim@gmail.com",
                                        "CSC",
                                    394,
                                                3.0,
                                                2,
                                                true,
                                                false,
                                                    "cool");

        userReviewRepo.getUserReviewEntitiesByUserReviewDepartmentAndUserReviewCourseNumber("CSC", 394);




    }



    @Test
    void getAllReview () {
        UserReviewEntity userReviewEntity = new UserReviewEntity();
        userReviewEntity.userReviewEmail = "abrahim@gmail.com";
        userReviewEntity.userReviewDepartment = "CSC";
        userReviewEntity.userReviewCourseNumber = 394;
        userReviewEntity.userReviewGPA = 0.00;
        userReviewEntity.userReviewDifficulty = 1;
        userReviewEntity.userReviewLike = Boolean.TRUE;
        userReviewEntity.userReviewDislike = Boolean.FALSE;
        userReviewEntity.userReviewFeedback = "cool";
        userReviewRepo.save(userReviewEntity);

        userReviewService.getAllReviews();
        verify(userReviewRepo).findAll();


    }

    @Test
    void getReviewByCourseDepartment() {
        UserReviewEntity userReviewEntity = new UserReviewEntity();
        userReviewEntity.userReviewEmail = "abrahim@gmail.com";
        userReviewEntity.userReviewDepartment = "CSC";
        userReviewEntity.userReviewCourseNumber = 394;
        userReviewEntity.userReviewGPA = 0.00;
        userReviewEntity.userReviewDifficulty = 1;
        userReviewEntity.userReviewLike = Boolean.TRUE;
        userReviewEntity.userReviewDislike = Boolean.FALSE;
        userReviewEntity.userReviewFeedback = "cool";
        userReviewRepo.save(userReviewEntity);

        userReviewService.getAllReviewByCourseDepartment("CSC", 394);
        verify(userReviewRepo).getUserReviewEntitiesByUserReviewDepartmentAndUserReviewCourseNumber("CSC", 394);


    }

    @Test
    void willDeleteReview(){
        UserReviewEntity userReviewEntity = new UserReviewEntity();
        userReviewEntity.setUserReviewID(1L);
        userReviewEntity.userReviewEmail = "abrahim@gmail.com";
        userReviewEntity.userReviewDepartment = "CSC";
        userReviewEntity.userReviewCourseNumber = 394;
        userReviewEntity.userReviewGPA = 0.00;
        userReviewEntity.userReviewDifficulty = 1;
        userReviewEntity.userReviewLike = Boolean.TRUE;
        userReviewEntity.userReviewDislike = Boolean.FALSE;
        userReviewEntity.userReviewFeedback = "cool";
        userReviewRepo.save(userReviewEntity);



        when(userReviewRepo.getUserReviewEntityByUserReviewEmailAndUserReviewCourseNumberAndUserReviewDepartment("abrahim@gmail.com", 394, "CSC")).thenReturn(userReviewEntity);
        userReviewService.deleteUserReviewByEmailCourseDept("abrahim@gmail.com", 394, "CSC");



    }


}