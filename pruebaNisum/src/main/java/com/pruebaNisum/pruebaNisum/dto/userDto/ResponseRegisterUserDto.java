package com.pruebaNisum.pruebaNisum.dto.userDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseRegisterUserDto {

    private String id;

    private String name;

    private String email;

    private Date dateCreated;

    private Date dateModified;

    private Date lastLogin;

    private String token;

    private boolean isactive;
}
