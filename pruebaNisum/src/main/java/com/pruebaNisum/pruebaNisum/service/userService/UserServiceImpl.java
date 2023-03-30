package com.pruebaNisum.pruebaNisum.service.userService;

import com.pruebaNisum.pruebaNisum.configuration.JwtUtilConfiguration;
import com.pruebaNisum.pruebaNisum.dto.userDto.RegisterUserDto;
import com.pruebaNisum.pruebaNisum.dto.userDto.ResponseRegisterUserDto;
import com.pruebaNisum.pruebaNisum.model.User;
import com.pruebaNisum.pruebaNisum.repository.IUserRepository;
import com.pruebaNisum.pruebaNisum.service.phoneService.IPhoneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;

@Service
@Validated
public class UserServiceImpl implements IUserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IPhoneService iPhoneService;

    @Autowired
    private JwtUtilConfiguration jwtUtilConfiguration;

    @Override
    public ResponseEntity<ResponseRegisterUserDto> registerUser(RegisterUserDto registerUserDto) {
        try {
            User userEntity = modelMapper.map(registerUserDto, User.class);
            userEntity.setIsactive(true);
            userEntity.setToken(jwtUtilConfiguration.generateJwtToken(userEntity.getEmail(), userEntity.isIsactive()));

            if (!isValidEmail(userEntity.getEmail())) {
                iUserRepository.save(userEntity);
                iPhoneService.updateUserIdInPhone(userEntity);
                return new ResponseEntity(modelMapper.map(userEntity, ResponseRegisterUserDto.class), HttpStatus.OK);
            } else {
                throw new Exception("El email " + userEntity.getEmail() + " ya se encuentra registrado");
            }
        } catch (Exception e) {
            return new ResponseEntity(Collections.singletonMap("mensaje", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity(iUserRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(Collections.singletonMap("mensaje", "Lo sentimos, tenemos algunas dificultades procesando la petición"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<User> getUserById(String id) {
        try {
            return new ResponseEntity(iUserRepository.findById(id).get(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(Collections.singletonMap("mensaje", "Es posible que el id no exista o no este correcto"),HttpStatus.BAD_REQUEST);
        }
    }

    private boolean isValidEmail(String email) {
        try {
            return iUserRepository.existsByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }

    }
}
