package com.csc363.group2.poc_demo.UserReview;

import com.csc363.group2.poc_demo.ClassController.ClassModelBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserReviewController {

    @Autowired
    UserReviewService userReviewService;

    @CrossOrigin(origins ="*")
    @PostMapping("api/v1/addUserReview")
    @ResponseBody
    public void addNewClass(@RequestBody UserReviewEntity userReviewEntity){
        userReviewService.addUserReview(userReviewEntity.userReviewEmail,userReviewEntity.userReviewCourse,userReviewEntity.userReviewGPA,userReviewEntity.userReviewDifficulty,userReviewEntity.userReviewLike,userReviewEntity.userReviewDislike,userReviewEntity.userReviewFeedback);
        System.out.println("----New User Review Has Been Added----");
    }

}
