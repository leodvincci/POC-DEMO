package com.csc363.group2.poc_demo.ClassRepo;

import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.ClassService.ClassService;
import com.csc363.group2.poc_demo.PocDemoApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(MockitoJUnitRunner.class)  // for JUnit4
@DataJpaTest
class ClassRepositoryTest {



//    @InjectMocks
//    @Autowired
//    ClassService classService;

//    @Mock
    @Autowired
    ClassRepository repository;
    ClassEntity classEntity = new ClassEntity();

    @Test
    void findByDepartmentAndClassNumber() {
        classEntity.setId(1L);
        classEntity.setClassName("Software Projects");
        classEntity.setClassDescription("Students will be provided with experience in team design, implementation and testing of a large software project.");
        classEntity.setDepartment("CSC");
        classEntity.setDislikes(0);
        classEntity.setClassNumber(394);
        classEntity.setLikes(0);
        classEntity.setCumGPA(0.00);
        classEntity.setCumDif(0.00);
        repository.save(classEntity);
//        Mockito.when(repository.findByDepartmentAndClassNumber("CSC",394)).thenReturn(classEntity);
//        assertEquals(new ArrayList<>(),classService.getAllClasses());
        assertEquals(classEntity,repository.findByDepartmentAndClassNumber("CSC",394));
    }


    @Test
    void findClassesTest() {
        classEntity.setId(1L);
        classEntity.setClassName("Software Projects");
        classEntity.setClassDescription("Students will be provided with experience in team design, implementation and testing of a large software project.");
        classEntity.setDepartment("CSC");
        classEntity.setDislikes(0);
        classEntity.setClassNumber(390);
        classEntity.setLikes(0);
        classEntity.setCumGPA(0.00);
        classEntity.setCumDif(0.00);
        repository.save(classEntity);
        ArrayList<ClassEntity> res = new ArrayList<>();
        res.add(classEntity);
        assertEquals(res,repository.findAll());
    }

}