package com.festibank.microservicio_cuenta.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String pais;
    private String localidad;
    private LocalDate fechaNacimiento;
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Cuenta> cuentaList;

}
