package com.festibank.microservicio_Movimiento.service.transferencia;

import com.festibank.microservicio_Movimiento.dto.transferencia.TransferenciaRequestDTOCreate;
import com.festibank.microservicio_Movimiento.dto.transferencia.TransferenciaResponseDTO;
import com.festibank.microservicio_Movimiento.dto.transferencia.TransferenciaResponseDTOListado;


public interface ITransferenciaService {

    TransferenciaResponseDTO detralleId (Long id);
    TransferenciaResponseDTOListado listadoPorCuentaId(Long cuentaId);
    TransferenciaResponseDTO crear (TransferenciaRequestDTOCreate transferDTOCreate);
    void cancelarTransferencia(Long id);
}
