package com.festibank.microservicio_cuenta.dto.cuenta;

import com.festibank.microservicio_cuenta.utils.EstadoCuenta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaRequestDTO {

    private int password;
    private EstadoCuenta estado;

}
