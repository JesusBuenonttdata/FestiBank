package com.festibank.microservicio_Movimiento.service.movimiento;

import com.festibank.microservicio_Movimiento.dto.movimiento.MovimientoRequestDTO;
import com.festibank.microservicio_Movimiento.dto.movimiento.MovimientoResponseDTO;
import com.festibank.microservicio_Movimiento.dto.movimiento.MovimientoResponseListDTO;


public interface IMovimientoService {

    MovimientoResponseDTO detalleId (Long id);
    MovimientoResponseListDTO listar (Long cuentaId);
    MovimientoResponseDTO credito (MovimientoRequestDTO request , Long cuentaId); // ingreso de dinero
    MovimientoResponseDTO debito (MovimientoRequestDTO request , Long cuentaId); // retirada de dinero

}
