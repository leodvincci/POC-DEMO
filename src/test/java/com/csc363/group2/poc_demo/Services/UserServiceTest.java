package com.csc363.group2.poc_demo.Services;

import com.csc363.group2.poc_demo.ClassController.ClassController;
import com.csc363.group2.poc_demo.ClassService.ClassService;
import com.csc363.group2.poc_demo.Controllers.UserController;
import com.csc363.group2.poc_demo.Repos.UserRepository;
import com.csc363.group2.poc_demo.appuser.AppUser;
import com.csc363.group2.poc_demo.appuser.AppUserRepository;
import com.csc363.group2.poc_demo.appuser.AppUserRole;
import com.csc363.group2.poc_demo.appuser.AppUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ClassController.class)
class UserServiceTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    UserController userController;
    @MockBean
    ClassService classService;

    @MockBean
    UserRepository userRepository;

    @MockBean
    AppUserRepository appUserRepository;

    @MockBean
    AppUser user;

    @MockBean
    UserService userService;

    @MockBean
    AppUserService appUserService;

    @MockBean
    BCryptPasswordEncoder bCryptPasswordEncoder;

    AppUser appUser = new AppUser(
            "Leo",
            "Penrose",
            "leodpenrose@gmail.com",
            "password123",
            AppUserRole.ADMIN
    );

    @Test
    void deleteUser() throws Exception {
        appUser.setId(1L);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/removeuser")
                        .param("id",appUser.getId().toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        assertEquals(Optional.empty(),userRepository.findById(appUser.getId()));

    }
}