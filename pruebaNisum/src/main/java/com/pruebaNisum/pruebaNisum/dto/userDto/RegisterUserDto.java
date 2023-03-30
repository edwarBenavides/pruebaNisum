package com.pruebaNisum.pruebaNisum.dto.userDto;

import com.pruebaNisum.pruebaNisum.dto.phoneDto.PhoneDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterUserDto {
    private String name;

    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
    message = "El email no es valido")
    private String email;

    @Pattern(regexp = "^(?=.*[0-9](?=.*[a-z])(?=.*[A-Z]))(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",
            message = "El password no es valido")
    private String password;

    private List<PhoneDto> phones;
}
