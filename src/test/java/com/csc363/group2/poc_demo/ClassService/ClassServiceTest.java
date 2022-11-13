package com.csc363.group2.poc_demo.ClassService;

import com.csc363.group2.poc_demo.ClassController.ClassController;
import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.ClassRepo.ClassRepository;
import com.csc363.group2.poc_demo.UserReview.UserReviewEntity;
import com.csc363.group2.poc_demo.UserReview.UserReviewRepo;
import com.csc363.group2.poc_demo.UserReview.UserReviewService;
import com.csc363.group2.poc_demo.appuser.AppUserService;
import org.h2.engine.User;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
class ClassServiceTest {





    ClassService classService;


    @Mock
    UserReviewRepo userReviewRepo;




    @Mock
    UserReviewService userReviewService;


    @Mock
    ClassRepository classRepository;

    private ClassEntity classEntity;





    private AutoCloseable autoCloseable;


    @BeforeEach
    void setUp() throws Exception{
        autoCloseable = MockitoAnnotations.openMocks(this);
        classService = new ClassService(classRepository);
    }













//    ClassService classService = new ClassService();

    @Test
    void getAllClasses() throws Exception{
//        List<ClassEntity> lst = new ArrayList<>();
//        List<ClassEntity> classList = repository.findAll();
//        assertEquals(lst,classList);
        ClassEntity classEntity1 = new ClassEntity();
        classEntity1.setId(1L);
        classEntity1.setClassName("Software Projects");
        classEntity1.setClassDescription("Students will be provided with experience in team design, implementation and testing of a large software project.");
        classEntity1.setDepartment("CSC");
        classEntity1.setDislikes(0);
        classEntity1.setClassNumber(394);
        classEntity1.setLikes(0);
        classEntity1.setCumGPA(0.00);
        classEntity1.setCumDif(0.00);
        classRepository.save(classEntity1);



        List<ClassEntity> classEntityList = new ArrayList<>();
        classService.getAllClasses();
        verify(classRepository).findAll();


    }



    @Test
    void WillgetByDepartmentAndClassNumber() {


        ClassEntity classEntity1 = new ClassEntity();
        classEntity1.setId(1L);
        classEntity1.setClassName("Software Projects");
        classEntity1.setClassDescription("Students will be provided with experience in team design, implementation and testing of a large software project.");
        classEntity1.setDepartment("CSC");
        classEntity1.setDislikes(0);
        classEntity1.setClassNumber(394);
        classEntity1.setLikes(0);
        classEntity1.setCumGPA(0.00);
        classEntity1.setCumDif(0.00);
        classRepository.save(classEntity1);



        List<ClassEntity> classEntityList = new ArrayList<>();
        classService.getByDepartmentAndClassNumber("CSC", 394);
        verify(classRepository).findByDepartmentAndClassNumber("CSC", 394);


    }

    @Test
    void WillAddClass() {




        List<ClassEntity> classEntityList = new ArrayList<>();
        classService.addClass("Software Projects",
                "Students will be provided with experience in team design, implementation and testing of a large software project.",
                "CSC",
                394,
                0.00,
                0.00,
                0,
                0);

        classRepository.findByDepartmentAndClassNumber("CSC", 394);



    }

    @Test
    void WillDeleteClass() {


        ClassEntity classEntity1 = new ClassEntity();
        classEntity1.setId(1L);
        classEntity1.setClassName("Software Projects");
        classEntity1.setClassDescription("Students will be provided with experience in team design, implementation and testing of a large software project.");
        classEntity1.setDepartment("CSC");
        classEntity1.setDislikes(0);
        classEntity1.setClassNumber(394);
        classEntity1.setLikes(0);
        classEntity1.setCumGPA(0.00);
        classEntity1.setCumDif(0.00);
        classRepository.save(classEntity1);




        List<ClassEntity> classEntityList = new ArrayList<>();

        when(classRepository.findByDepartmentAndClassNumber("CSC", 394)).thenReturn(classEntity1);
        classService.searchAndDeleteClass("CSC", 394);
        verify(classRepository).findByDepartmentAndClassNumber("CSC", 394);


    }

    @Test
    void WilUpDateGpa(){

        ClassEntity classEntity1 = new ClassEntity();
        classEntity1.setId(1L);
        classEntity1.setClassName("Software Projects");
        classEntity1.setClassDescription("Students will be provided with experience in team design, implementation and testing of a large software project.");
        classEntity1.setDepartment("CSC");
        classEntity1.setDislikes(0);
        classEntity1.setClassNumber(394);
        classEntity1.setLikes(0);
        classEntity1.setCumGPA(0.00);
        classEntity1.setCumDif(0.00);
        classRepository.save(classEntity1);






        when(classRepository.findByDepartmentAndClassNumber("CSC", 394)).thenReturn(classEntity1);
        classService.updateGPAbyDepartmentAndClassNumber("CSC", 394, 3.0, true,false);
        assertEquals(3.0, classRepository.findByDepartmentAndClassNumber("CSC", 394).getCumGPA());
        assertEquals(1.0, classRepository.findByDepartmentAndClassNumber("CSC", 394).getLikes());
        assertEquals(0.0, classRepository.findByDepartmentAndClassNumber("CSC", 394).getDislikes());



    }















}