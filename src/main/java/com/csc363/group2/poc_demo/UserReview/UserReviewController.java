package com.csc363.group2.poc_demo.UserReview;

import com.csc363.group2.poc_demo.ClassController.ClassModelBody;
import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.ClassService.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserReviewController {

    @Autowired
    UserReviewService userReviewService;

    @Autowired
    ClassService classService;

    @CrossOrigin(origins ="*")
    @PostMapping("api/v1/addUserReview")
    @ResponseBody
    public double addNewClass(@RequestBody UserReviewEntity userReviewEntity){
        userReviewService.addUserReview(userReviewEntity.userReviewEmail,userReviewEntity.userReviewDepartment,userReviewEntity.userReviewCourseNumber,userReviewEntity.userReviewGPA,userReviewEntity.userReviewDifficulty,userReviewEntity.userReviewLike,userReviewEntity.userReviewDislike,userReviewEntity.userReviewFeedback);
        System.out.println("----New User Review Has Been Added----");
        ClassEntity theClass = classService.getByDepartmentAndClassNumber(userReviewEntity.getUserReviewDepartment(), userReviewEntity.getUserReviewCourseNumber());
        System.out.println("GPA: " + theClass.getCumGPA() + 42);
        return theClass.getCumGPA() + 42;
    }


    @CrossOrigin(origins ="*")
    @GetMapping("api/v1/getAllReviews")
    public List<UserReviewEntity> getAllReviews(){
        return userReviewService.getAllReviews();
    }

}
