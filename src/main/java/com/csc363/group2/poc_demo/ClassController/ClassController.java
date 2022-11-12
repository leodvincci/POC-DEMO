package com.csc363.group2.poc_demo.ClassController;

import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.ClassService.ClassService;
import com.csc363.group2.poc_demo.appuser.AppUser;
import com.csc363.group2.poc_demo.appuser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassController {

    @Autowired
    public ClassService classService;

    @Autowired
    AppUserRepository appUserRepository;


    @CrossOrigin(origins ="*")
    @GetMapping("api/v1/getAllClasses")
    public List<ClassEntity> getAllClasses(){
        List classList = classService.getAllClasses();
        System.out.println(classList.toArray());
        return classList;

    }

    @CrossOrigin(origins ="*")
    @PostMapping("api/v1/addClass")
    @ResponseBody
    public void addNewClass(@RequestBody ClassModelBody classModelBody){
        classService.addClass(classModelBody.className, classModelBody.classDescription,classModelBody.department,classModelBody.classNumber,classModelBody.cumGPA,classModelBody.cumDif,classModelBody.likes,classModelBody.dislikes);
//        userServicevice.updateUser(appUserModelBody.getFirstName(),appUserModelBody.getLastName(),appUserModelBody.getEmail(),appUserService.generateNewPassword(appUserModelBody.getPassword()),appUserModelBody.getRole());
        System.out.println("New Course Has Been Added");
    }


    @CrossOrigin(origins ="*")
    @GetMapping("api/v1/getClassByNameAndNumber")
    @ResponseBody
    public ClassEntity findClassByNameAndNumber(@RequestParam String department, int classNumber){
        ClassEntity foundClass = classService.getByDepartmentAndClassNumber(department,classNumber);
        System.out.println("Searching!");
        return foundClass;
    }

    @CrossOrigin(origins ="*")
    @GetMapping("api/v1/getClassAndReviewByDeptAndNum")
    @ResponseBody
    public List getClassAndReviewByDeptAndNum(@RequestParam String department, int classNumber){
        System.out.println("LOOK AT THIS SHIT!!!---->" + classService.getClassAndReviewByDeptAndNum(department,classNumber));
        System.out.println("hello world");
        return classService.getClassAndReviewByDeptAndNum(department,classNumber);
    }

    @CrossOrigin(origins ="*")
    @GetMapping("api/v1/getSavedStudentCourses")
    public List getClassAndReviewByDeptAndNum(@AuthenticationPrincipal AppUser appUser){
        System.out.println("Getting saved classes for: " + appUser.getUsername());
        return classService.getSavedStudentCourses(appUser);
    }

    @CrossOrigin(origins ="*")
    @DeleteMapping("api/v1/searchandremoveclass")
    @ResponseBody
    public void DeleteClassByDepartAndNumber(@RequestParam String department, int classNumber){
        ClassEntity foundClass = classService.getByDepartmentAndClassNumber(department,classNumber);
        System.out.println("Searching!");
        classService.searchAndDeleteClass(foundClass.getDepartment(), foundClass.getClassNumber());
    }


    @CrossOrigin(origins ="*")
    @PostMapping("api/v1/saveStudentCourse")
    @ResponseBody
    public void saveStudentCourse(@RequestParam String department, int classNumber,@AuthenticationPrincipal AppUser appUser){
        classService.saveCourseWithStudent(department,classNumber,appUserRepository.getAppUserByEmail(appUser.getUsername()));
    }


}
