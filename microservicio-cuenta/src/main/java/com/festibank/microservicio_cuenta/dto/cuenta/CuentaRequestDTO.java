package com.festibank.microservicio_cuenta.dto.cuenta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaRequestDTO {

    private String password;
    private String estado;

}
