package com.pruebaNisum.pruebaNisum.controller;

import com.pruebaNisum.pruebaNisum.dto.userDto.RegisterUserDto;
import com.pruebaNisum.pruebaNisum.dto.userDto.ResponseRegisterUserDto;
import com.pruebaNisum.pruebaNisum.model.User;
import com.pruebaNisum.pruebaNisum.service.userService.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @ApiOperation(value = "Registra un nuevo usuario", notes = "Para registrar un nuevo usuario tenga en cuenta que " +
            "se está validando el formato del correo y la propiedad password debe contener: minúsculas, " +
            "mayúsculas, números, un carácter especial y debe ser mayor de 8 caracteres y menor a 20")
    @PostMapping("/registerUser")
    public ResponseEntity<ResponseRegisterUserDto> registerUser(@RequestBody RegisterUserDto registerUserDto){
        try {
            return iUserService.registerUser(registerUserDto);
        }catch (Exception e){
            return new ResponseEntity(Collections.singletonMap("mensaje", e.getMessage().replaceAll("registerUser\\.registerUserDto\\.", "")),
                    HttpStatus.BAD_REQUEST);
        }

    }

    @ApiOperation(value = "Lista todos los usuarios registrados")
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return iUserService.getAllUsers();
    }

    @ApiOperation(value = "Consulta un usuario por ID")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id){
        return iUserService.getUserById(id);
    }

}
