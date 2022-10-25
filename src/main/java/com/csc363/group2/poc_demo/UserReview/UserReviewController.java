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
    public void addNewReview(@RequestBody UserReviewEntity userReviewEntity){
        userReviewService.addUserReview(userReviewEntity.userReviewEmail,userReviewEntity.userReviewDepartment,userReviewEntity.userReviewCourseNumber,userReviewEntity.userReviewGPA,userReviewEntity.userReviewDifficulty,userReviewEntity.userReviewLike,userReviewEntity.userReviewDislike,userReviewEntity.userReviewFeedback);
        System.out.println("----New User Review Has Been Added----");
//        ClassEntity theClass = classService.getByDepartmentAndClassNumber(userReviewEntity.getUserReviewDepartment(), userReviewEntity.getUserReviewCourseNumber());
        double theNewGPA = calGPA(userReviewEntity);
        System.out.println("Updating GPA: " + theNewGPA);
        classService.updateGPAbyDepartmentAndClassNumber(userReviewEntity.userReviewDepartment, userReviewEntity.userReviewCourseNumber,theNewGPA,userReviewEntity.userReviewLike,userReviewEntity.userReviewDislike);
    }

    public double calGPA(UserReviewEntity review){
        List<UserReviewEntity> allReviews = userReviewService.getAllReviewByCourseDepartment(review.userReviewDepartment,review.userReviewCourseNumber);
        int totalReviews = allReviews.size();
        double sumOfGPA = 0;

        for (int i = 0; i < totalReviews; i++){
            UserReviewEntity theReview = allReviews.get(i);
            System.out.println(theReview.userReviewGPA);
            sumOfGPA = theReview.userReviewGPA + sumOfGPA;
        }
        System.out.println("Course Number: " + review.userReviewCourseNumber);
        System.out.println("GPA Sum: " + sumOfGPA);
        System.out.println("Total Reviews: " + (totalReviews));
        System.out.println("Cum GPA: " + sumOfGPA / (totalReviews));
        return sumOfGPA / (totalReviews );

    }


    @CrossOrigin(origins ="*")
    @GetMapping("api/v1/getAllReviews")
    public List<UserReviewEntity> getAllReviews(){
        return userReviewService.getAllReviews();
    }

    @CrossOrigin(origins ="*")
    @GetMapping("api/v1/getAllReviewsByCourseDepartment")
    @ResponseBody
    public List<UserReviewEntity> getAllReviewsByCourseDepartment(@RequestBody UserReviewEntity userReview){
        System.out.println("Getting All Reviews By Course and Department!");
        return userReviewService.getAllReviewByCourseDepartment(userReview.userReviewDepartment,userReview.userReviewCourseNumber);
    }

    @CrossOrigin(origins ="*")
    @DeleteMapping("api/v1/deleteReviewByEmailCourseDept")
    @ResponseBody
    public void deleteReviewByEmailCourseDept(@RequestParam String userEmail, int courseNumber, String department){
        System.out.println("Deleting Review!");
        userReviewService.deleteUserReviewByEmailCourseDept(userEmail,courseNumber,department);
    }


    @CrossOrigin(origins ="*")
    @ResponseBody
    @GetMapping("api/v1/getCumGPA")
    public double getCumGPA(@RequestBody UserReviewEntity review){
        List<UserReviewEntity> allReviews = userReviewService.getAllReviewByCourseDepartment(review.userReviewDepartment,review.userReviewCourseNumber);
        int totalReviews = allReviews.size();
        double sumOfGPA = 0;

        for (int i = 0; i < totalReviews; i++){
            UserReviewEntity theReview = allReviews.get(i);
            sumOfGPA = theReview.userReviewGPA + sumOfGPA;
        }
        System.out.println("Course Number: " + review.userReviewCourseNumber);
        System.out.println("GPA Sum: " + sumOfGPA);
        System.out.println("Total Reviews: " + totalReviews);
        return sumOfGPA / totalReviews;

    }

}
