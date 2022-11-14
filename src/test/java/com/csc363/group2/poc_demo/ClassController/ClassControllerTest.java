package com.csc363.group2.poc_demo.ClassController;

import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.ClassRepo.ClassRepository;
import com.csc363.group2.poc_demo.ClassService.ClassService;
import com.csc363.group2.poc_demo.appuser.AppUserRepository;
import com.csc363.group2.poc_demo.appuser.AppUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    ClassRepository classRepository;

    @MockBean
    AppUserRepository appUserRepository;
    @MockBean
    ClassEntity classEntity;

    @MockBean
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Test
    void getAllClasses() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/getAllClasses");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals("[]",result.getResponse().getContentAsString());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    ClassModelBody classModelBody = new ClassModelBody(
            "Computer Science I",
            "Learn Computer Science",
            "CSC",
            101,
            0,
            0,
            0,
            0
    );
    @Test
    void addNewClass() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/api/v1/addClass")
                .content(asJsonString(classModelBody))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                ;
        MvcResult result = mockMvc.perform(request)
//                .andExpect(status().isCreated())
                .andReturn();
//        assertEquals("[]",result.getResponse().getContentAsString());
    }

    @Test
    void findClassByNameAndNumber() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/getClassByNameAndNumber")
                .param("department","CSC")
                .param("classNumber", String.valueOf(394));
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        assertEquals("",result.getResponse().getContentAsString());
    }

    @Test
    void getClassAndReviewByDeptAndNum() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/getClassAndReviewByDeptAndNum")
                .param("department","CSC")
                .param("classNumber", String.valueOf(394));
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        assertEquals(new ArrayList<>().toString(),result.getResponse().getContentAsString());
    }

    @Test
    void deleteClassByDepartAndNumber() throws Exception {

//        .addClass(
//                "Computer Science",
//                "A Good Class",
//                "CSC",
//                394,
//                0,
//                0,
//                0,
//                0
//        );
        classEntity.setId(1L);
        classEntity.setClassName("Software Projects");
        classEntity.setClassDescription("Students will be provided with experience in team design, implementation and testing of a large software project.");
        classEntity.setDepartment("CSC");
        classEntity.setDislikes(0);
        classEntity.setClassNumber(394);
        classEntity.setLikes(0);
        classEntity.setCumGPA(0.00);
        classEntity.setCumDif(0.00);
//        classRepository.save(classEntity);
//        ClassController controller = new ClassController();
//        RequestBuilder request = MockMvcRequestBuilders.delete("/api/v1/searchandremoveclass")
//                .param("department","CSC")
//                .param("classNumber", String.valueOf(394));
//
////        MvcResult result = mockMvc.perform(request)
////                .andExpect(status().isOk())
////                .andDo(print())
////                .andReturn();
//        assertEquals(classEntity,controller.DeleteClassByDepartAndNumber("CSC",394));

        Mockito.when(classService.getByDepartmentAndClassNumber("CSC",394)).thenReturn(classEntity);
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/v1/searchandremoveclass")
                    .param("department","CSC")
                    .param("classNumber", String.valueOf(394))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}