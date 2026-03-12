package com.festibank.microservicio_Movimiento.dto.comunicacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaRequestDTO {

    private String nombre;
    private int password;
}
