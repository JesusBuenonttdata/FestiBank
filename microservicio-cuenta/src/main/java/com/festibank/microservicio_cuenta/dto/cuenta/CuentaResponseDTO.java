package com.festibank.microservicio_cuenta.dto.cuenta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaResponseDTO {

    private String nombre;
    private String iban;
    private String tipo;
    private String estado;
    private BigDecimal saldo;
}
