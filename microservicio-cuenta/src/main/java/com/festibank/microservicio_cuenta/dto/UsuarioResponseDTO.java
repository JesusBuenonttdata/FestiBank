package com.festibank.microservicio_cuenta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {

    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String pais;
    private String localidad;
    private LocalDate fechaNacimiento;


}
