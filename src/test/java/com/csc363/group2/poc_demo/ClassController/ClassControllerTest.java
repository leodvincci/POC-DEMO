package com.csc363.group2.poc_demo.ClassController;

import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.ClassService.ClassService;
import com.csc363.group2.poc_demo.appuser.AppUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ClassController.class)
class ClassControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ClassService classService;
    @MockBean
    AppUserService appUserService;

    @MockBean
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Test
    void getAllClasses() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/getAllClasses");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals("[]",result.getResponse().getContentAsString());
    }

    @Test
    void addNewClass()  {

    }

    @Test
    void findClassByNameAndNumber() {

    }

    @Test
    void getClassAndReviewByDeptAndNum() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/getClassAndReviewByDeptAndNum");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals("",result.getResponse().getContentAsString());
    }

    @Test
    void deleteClassByDepartAndNumber() {
    }
}