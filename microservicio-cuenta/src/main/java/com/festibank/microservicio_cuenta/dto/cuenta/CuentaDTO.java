package com.festibank.microservicio_cuenta.dto.cuenta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDTO {

    private String nombre;
    private String password;
}
