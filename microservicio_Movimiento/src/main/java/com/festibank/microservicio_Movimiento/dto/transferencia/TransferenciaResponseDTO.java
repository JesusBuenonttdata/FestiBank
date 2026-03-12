package com.festibank.microservicio_Movimiento.dto.transferencia;

import com.festibank.microservicio_Movimiento.utils.EstadoTransferencia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaResponseDTO {

    private Long cuentaOrigenId;
    private Long cuentaDestinoId;
    private BigDecimal importe;
    private EstadoTransferencia estado;
    private LocalDateTime fechaCreacion;
}
