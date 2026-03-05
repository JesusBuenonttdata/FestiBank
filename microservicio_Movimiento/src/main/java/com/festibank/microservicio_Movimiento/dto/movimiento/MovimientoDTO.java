package com.festibank.microservicio_Movimiento.dto.movimiento;

import com.festibank.microservicio_Movimiento.utils.TipoMovimiento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoDTO {

    private BigDecimal importe;
    private TipoMovimiento tipo;
    private String referencia;
    private LocalDateTime fechaCreacion;

}
