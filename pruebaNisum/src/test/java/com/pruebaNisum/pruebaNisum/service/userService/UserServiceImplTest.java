package com.pruebaNisum.pruebaNisum.service.userService;

import com.pruebaNisum.pruebaNisum.dto.userDto.RegisterUserDto;
import com.pruebaNisum.pruebaNisum.dto.userDto.ResponseRegisterUserDto;
import com.pruebaNisum.pruebaNisum.model.User;
import com.pruebaNisum.pruebaNisum.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    @Mock
    private IUserRepository iUserRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User userEntity;

    private String id;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

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

        id = "23423-2dfwe234-222";
    }

    @Test
    void registerUser() {
        when(iUserRepository.save(any(User.class))).thenReturn(userEntity);
        assertNotNull(userService.registerUser(new RegisterUserDto()));
    }

    @Test
    public void testRegisterUser_DuplicateEmail(){
        RegisterUserDto registerUserDto = RegisterUserDto.builder()
                .email("prueba@gmail.com")
                .password("23eddRT##")
                .build();
        when(iUserRepository.existsByEmail(anyString())).thenReturn(true);
        ResponseEntity<ResponseRegisterUserDto> response = userService.registerUser(registerUserDto);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void getAllUsers() {
        when(iUserRepository.findAll()).thenReturn(Arrays.asList(userEntity));
        assertNotNull(userService.getAllUsers());
    }


    @Test
    void getUserById() {
        when(iUserRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(userEntity));
        assertNotNull(userService.getUserById(id));
    }

    @Test
    public void testGetUserById_InvalidId() {
        when(iUserRepository.findById(anyString())).thenReturn(Optional.empty());
        ResponseEntity<User> response = userService.getUserById("invalid_id");
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    }
}