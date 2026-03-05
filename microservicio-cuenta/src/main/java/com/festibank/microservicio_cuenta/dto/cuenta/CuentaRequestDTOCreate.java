package com.festibank.microservicio_cuenta.dto.cuenta;

import com.festibank.microservicio_cuenta.utils.TipoCuenta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaRequestDTOCreate {

    private String nombre;
    private TipoCuenta tipo;

}
