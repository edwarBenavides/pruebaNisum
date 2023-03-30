package com.pruebaNisum.pruebaNisum.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebaNisum.pruebaNisum.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.awt.*;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
class UserControllerTest {

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private User userEntity;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        userEntity = User.builder()
                .id("23423-2dfwe234-222")
                .email("prueba@gmail.com")
                .name("edwar prueba")
                .password("23eddRT##")
                .dateCreated(new Date())
                .dateModified(new Date())
                .lastLogin(new Date())
                .token("rrrt23j4h2k3j4hk2j34k3j4hkj23h4nk2")
                .build();
    }

    @Test
    void registerUser() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/registerUser")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(mapToJson(userEntity)))
                .andReturn();
        assertEquals(200,mvcResult.getResponse().getStatus());
    }

    @Test
    void registerUserBadRequest() throws Exception {
        User user = userEntity;
        user.setEmail("prueba");
        user.setPassword("prueba");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/registerUser")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(mapToJson(user)))
                .andReturn();
        assertEquals(400,mvcResult.getResponse().getStatus());
    }

    @Test
    void getAllUsers() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/allUsers")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        assertEquals(200,mvcResult.getResponse().getStatus());
    }

    @Test
    void getUserById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/uuiddeprueba1")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        assertEquals(400,mvcResult.getResponse().getStatus());
    }

    private String mapToJson(Object object) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}