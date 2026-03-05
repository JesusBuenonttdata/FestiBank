package com.festibank.microservicio_Movimiento.service.movimiento;

import com.festibank.microservicio_Movimiento.dto.movimiento.MovimientoResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IMovimientoService {

    MovimientoResponseDTO detalleId (Long id);
    List<MovimientoResponseDTO> listar (Long cuentaId);
    MovimientoResponseDTO credito (BigDecimal dinero , Long cuentaId); // ingreso de dinero
    MovimientoResponseDTO debito (BigDecimal dinero , Long cuentaId); // retirada de dinero

}
