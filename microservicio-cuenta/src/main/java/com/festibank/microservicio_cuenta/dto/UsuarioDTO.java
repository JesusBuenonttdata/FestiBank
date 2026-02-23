package com.festibank.microservicio_cuenta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private String nombre;
    private String apellidos;
    private String email;
    private String nombreCuenta;
}
