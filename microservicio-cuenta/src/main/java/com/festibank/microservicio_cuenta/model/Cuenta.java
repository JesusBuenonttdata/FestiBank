package com.festibank.microservicio_cuenta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.festibank.microservicio_cuenta.utils.EstadoCuenta;
import com.festibank.microservicio_cuenta.utils.TipoCuenta;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String nombre;
    private int password; //es diferente al usuario , se genera sola
    private String iban; // se genera automáticamente
    private TipoCuenta tipo; // Si es cuenta corriente o ahorro
    private EstadoCuenta estado; // Si la cuenta está activa o bloqueada
    private BigDecimal saldo ; // Empieza desde 0

    // Un usuario puede tener varias cuentas
    @ManyToOne
    @JsonIgnore
    private Usuario usuario;
}
