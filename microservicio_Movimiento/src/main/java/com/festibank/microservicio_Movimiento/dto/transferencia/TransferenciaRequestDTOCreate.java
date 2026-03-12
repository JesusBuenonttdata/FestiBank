package com.festibank.microservicio_Movimiento.dto.transferencia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaRequestDTOCreate {

    private String nombre;
    private int password;
    private Long cuentaOrigenId;
    private Long cuentaDestinoId;
    private BigDecimal importe;
    private String referencia;
}
