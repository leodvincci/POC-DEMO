package com.csc363.group2.poc_demo.ClassService;

import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.ClassRepo.ClassRepository;
import com.csc363.group2.poc_demo.Repos.UserRepository;
import com.csc363.group2.poc_demo.UserReview.UserReviewEntity;
import com.csc363.group2.poc_demo.UserReview.UserReviewService;
import com.csc363.group2.poc_demo.appuser.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private UserReviewService userReviewService;

    public List<ClassEntity> getAllClasses(){
        System.out.println("Getting All Classes");
        List<ClassEntity> classList = classRepository.findAll();
        return classList;
    }

    public ClassEntity getByDepartmentAndClassNumber(String department, int classNumber){
        System.out.println("Searching for Class By Name and Number!");
        ClassEntity classEntity = classRepository.findByDepartmentAndClassNumber(department,classNumber);
        return classEntity;
    }

    public List getClassAndReviewByDeptAndNum(String department, int classNumber){
        System.out.println("Searching for Class By Name and Number!");
        ClassEntity classEntity = classRepository.findByDepartmentAndClassNumber(department,classNumber);
        List allTheReviews = userReviewService.getAllReviewByCourseDepartment(department,classNumber);
        List emp = new ArrayList<>();
//        System.out.println("LOOK" + emp);
//        System.out.println("Look at this:" + classEntity);
//        System.out.println("Look at this:" + allTheReviews);
        if(classEntity == null){
            System.out.println("LOOK I'm NULLLL!");

            return List.of(emp,allTheReviews);
        }
        return List.of(classEntity,allTheReviews);
    }

    public void updateGPAbyDepartmentAndClassNumber(String department, int classNumber, double gpa,boolean likes, boolean dislikes){
        System.out.println("Searching for Class By Name and Number!");
        int likeCount;
        int dislikeCount;
        if(likes){
            likeCount = 1;
        }else {
            likeCount = 0;
        }

        if(dislikes){
            dislikeCount = 1;
        }else {
            dislikeCount = 0;
        }
        ClassEntity classEntity = classRepository.findByDepartmentAndClassNumber(department,classNumber);
        System.out.println("Found Class...Updating GPA");
        classEntity.setCumGPA(gpa);
        classEntity.setLikes(classEntity.getLikes() + likeCount);
        classEntity.setDislikes(classEntity.getDislikes() + dislikeCount);
        classRepository.save(classEntity);
        System.out.println("GPA has be Updated to : " + gpa);
        System.out.println("Like Count " + likeCount);
        System.out.println("Dislike Count " + dislikeCount);
    }


    public void searchAndDeleteClass(String department, int classNumber){
        ClassEntity theClass = getByDepartmentAndClassNumber(department,classNumber);
        System.out.println("The Course has been Found.");
        classRepository.deleteById(theClass.getId());
        System.out.println("The Course has been removed from database");
    }

    public void addClass(String className, String classDes, String department, int classNumber, double cumGPA, double cumDif,int likes, int dislikes){

        ClassEntity classEntity = new ClassEntity();
        classEntity.setClassName(className);
        classEntity.setClassDescription(classDes);
        classEntity.setDepartment(department);
        classEntity.setClassNumber(classNumber);
        classEntity.setCumGPA(cumGPA);
        classEntity.setCumDif(cumDif);
        classEntity.setLikes(likes);
        classEntity.setDislikes(dislikes);

        classRepository.save(classEntity);
        System.out.println("Class Was Saved");

    }

    public void saveCourseWithStudent(String classDept, int classNumber, AppUser appUser){
            ClassEntity course = getByDepartmentAndClassNumber(classDept,classNumber);
            course.addStudents(appUser);
            classRepository.save(course);


    }

}
