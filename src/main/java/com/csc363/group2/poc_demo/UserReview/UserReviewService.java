package com.csc363.group2.poc_demo.UserReview;

import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReviewService {

    @Autowired
    UserReviewRepo userReviewRepo;


    public void addUserReview(String email, String department,int courseNumber, Double gpa, Integer difficulty, boolean like, boolean dislike, String feedback){
        UserReviewEntity userReviewEntity = new UserReviewEntity();
        userReviewEntity.userReviewEmail = email;
        userReviewEntity.userReviewDepartment = department;
        userReviewEntity.userReviewCourseNumber= courseNumber;
        userReviewEntity.userReviewGPA = gpa;
        userReviewEntity.userReviewDifficulty = difficulty;
        userReviewEntity.userReviewLike = like;
        userReviewEntity.userReviewDislike = dislike;
        userReviewEntity.userReviewFeedback = feedback;
        userReviewRepo.save(userReviewEntity);
        System.out.println("New Review Has Been Added!");



    }

    public List<UserReviewEntity> getAllReviews(){
        System.out.println("Getting All Reviews");
        List<UserReviewEntity> userReviewList = userReviewRepo.findAll();
        return userReviewList;
    }


    public List<UserReviewEntity> getAllReviewByCourseDepartment(String department, int courseNumber){
        System.out.println("Getting All Reviews By Course and Department");
        List<UserReviewEntity> userReviewList = userReviewRepo.getUserReviewEntitiesByUserReviewDepartmentAndUserReviewCourseNumber(department,courseNumber);
        return userReviewList;
    }

}
