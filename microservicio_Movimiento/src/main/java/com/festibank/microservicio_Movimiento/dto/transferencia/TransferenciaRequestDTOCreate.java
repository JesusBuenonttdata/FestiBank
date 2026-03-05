package com.festibank.microservicio_Movimiento.dto.transferencia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaRequestDTOCreate {

    Long cuentaOrigenId ;
    Long cuentaDestinoId;
    BigDecimal importe ;
    String descripcion;
}
