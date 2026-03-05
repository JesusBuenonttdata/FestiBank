package com.festibank.microservicio_cuenta.dto.usuario;

import com.festibank.microservicio_cuenta.model.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTODetalle {

    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String pais;
    private String localidad;
    private LocalDate fechaNacimiento;
    private List<Cuenta> cuentaList;

}
