package com.festibank.microservicio_Movimiento.service.transferencia;

import com.festibank.microservicio_Movimiento.dto.transferencia.TransferenciaRequestDTOCreate;
import com.festibank.microservicio_Movimiento.dto.transferencia.TransferenciaResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ITransferenciaService {

    TransferenciaResponseDTO detralleId (Long id);
    List<TransferenciaResponseDTOListado> listadoPorCuentaId(Long cuentaId);
    TransferenciaResponseDTO crear (TransferenciaRequestDTOCreate transferDTOCreate);
    void cancelarTransferencia(Long id);
}
