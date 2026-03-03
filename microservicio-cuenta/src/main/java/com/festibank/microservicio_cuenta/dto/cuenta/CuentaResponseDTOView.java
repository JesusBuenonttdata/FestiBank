package com.festibank.microservicio_cuenta.dto.cuenta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaResponseDTOView {

    private String nombre;
    private int password;
}
