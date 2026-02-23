package com.festibank.microservicio_cuenta.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@Entity
//@Table(name = "usuarios")
public class Usuario {

    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String nombreCuenta;
    private String password;
}
