//package com.csc363.group2.poc_demo.ClassService;
//
//import com.csc363.group2.poc_demo.ClassController.ClassController;
//import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
//import com.csc363.group2.poc_demo.ClassRepo.ClassRepository;
//import com.csc363.group2.poc_demo.appuser.AppUserService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ClassService.class)
//class ClassServiceTest {
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
//
//    @Test
//    void getAllClasses() {
//        List<ClassEntity> lst = new ArrayList<>();
//        List<ClassEntity> classList = repository.findAll();
//        assertEquals(lst,classList);
//    }
//}