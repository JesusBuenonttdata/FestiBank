package com.festibank.microservicio_Movimiento.dto.comunicacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaResponseDTO {

    private Long cuentaId;
    private BigDecimal saldo;
}
