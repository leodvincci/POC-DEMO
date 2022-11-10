package com.csc363.group2.poc_demo.ClassService;

import com.csc363.group2.poc_demo.ClassController.ClassController;
import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.ClassRepo.ClassRepository;
import com.csc363.group2.poc_demo.appuser.AppUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
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
@DataJpaTest
class ClassServiceTest {
//
//    @MockBean
//    private ClassRepository repository;
//
//
//    @MockBean
//    private ClassEntity entity;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    ClassService classService;
//    @MockBean
//    AppUserService appUserService;
//
//    @MockBean
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    ClassRepository classRepository;

    ClassService classService = new ClassService();

    ClassEntity classEntity = new ClassEntity();

//    ClassService classService = new ClassService();

    @Test
    void getAllClasses() {
//        List<ClassEntity> lst = new ArrayList<>();
//        List<ClassEntity> classList = repository.findAll();
//        assertEquals(lst,classList);

        classEntity.setId(1L);
        classEntity.setClassName("Software Projects");
        classEntity.setClassDescription("Students will be provided with experience in team design, implementation and testing of a large software project.");
        classEntity.setDepartment("CSC");
        classEntity.setDislikes(0);
        classEntity.setClassNumber(390);
        classEntity.setLikes(0);
        classEntity.setCumGPA(0.00);
        classEntity.setCumDif(0.00);
        classRepository.save(classEntity);
        ArrayList<ClassEntity> res = new ArrayList<>();
        res.add(classEntity);
//        assertEquals(res,repository.findAll());

        assertEquals(res,classRepository.findAll());

    }

    @Test
    void getByDepartmentAndClassNumber() {
    }
}