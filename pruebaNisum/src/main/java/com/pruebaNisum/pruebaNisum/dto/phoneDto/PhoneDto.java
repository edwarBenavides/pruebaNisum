package com.pruebaNisum.pruebaNisum.dto.phoneDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PhoneDto {

    private String number;

    private String citycode;

    private String countrycode;
}
