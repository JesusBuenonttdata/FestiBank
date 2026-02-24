package com.festibank.microservicio_cuenta.model;

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
    private String password; //es diferente al usuario , se genera sola
    private String iban; // se genera automáticamente
    private String tipo; // Si es cuenta corriente o ahorro
    private String estado; // Si la cuenta está activa o bloqueada
    private BigDecimal saldo ; // Empieza desde 0
    // un usuario puede tener varias cuentas
}
