package com.csc363.group2.poc_demo.UserReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserReviewService {

    @Autowired
    UserReviewRepo userReviewRepo;


    public void addUserReview(String email, String course, Double gpa, Integer difficulty, boolean like, boolean dislike, String feedback){
        UserReviewEntity userReviewEntity = new UserReviewEntity();
        userReviewEntity.userReviewEmail = email;
        userReviewEntity.userReviewCourse = course;
        userReviewEntity.userReviewGPA = gpa;
        userReviewEntity.userReviewDifficulty = difficulty;
        userReviewEntity.userReviewLike = like;
        userReviewEntity.userReviewDislike = dislike;
        userReviewEntity.userReviewFeedback = feedback;
        userReviewRepo.save(userReviewEntity);
        System.out.println("New Review Has Been Added!");

    }

}
