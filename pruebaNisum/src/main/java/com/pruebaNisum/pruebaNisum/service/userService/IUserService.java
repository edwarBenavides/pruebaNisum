package com.pruebaNisum.pruebaNisum.service.userService;

import com.pruebaNisum.pruebaNisum.dto.userDto.RegisterUserDto;
import com.pruebaNisum.pruebaNisum.dto.userDto.ResponseRegisterUserDto;
import com.pruebaNisum.pruebaNisum.model.User;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

public interface IUserService {
    ResponseEntity<ResponseRegisterUserDto> registerUser(@Valid RegisterUserDto registerUserDto);
    ResponseEntity<List<User>> getAllUsers();
    ResponseEntity<User> getUserById(String id);

}
