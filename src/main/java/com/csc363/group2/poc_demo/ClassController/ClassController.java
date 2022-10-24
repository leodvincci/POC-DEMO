package com.csc363.group2.poc_demo.ClassController;

import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.ClassService.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassController {

    @Autowired
    public ClassService classService;


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
    @DeleteMapping("api/v1/searchandremoveclass")
    @ResponseBody
    public void DeleteClassByDepartAndNumber(@RequestBody ClassModelBody classModelBody){
        ClassEntity foundClass = classService.getByDepartmentAndClassNumber(classModelBody.department,classModelBody.classNumber);
        System.out.println("Searching!");
        classService.searchAndDeleteClass(foundClass.getDepartment(), foundClass.getClassNumber());
    }

}
