package com.festibank.microservicio_Movimiento.mapper.transferencia;


import com.festibank.microservicio_Movimiento.dto.transferencia.TransferenciaResponseDTO;
import com.festibank.microservicio_Movimiento.dto.transferencia.TransferenciaResponseDTOListado;
import com.festibank.microservicio_Movimiento.model.Transferencia;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransferenciaMapper {

    public static TransferenciaResponseDTO toDTO (Transferencia transferencia){
        TransferenciaResponseDTO dto = new TransferenciaResponseDTO();
        dto.setEstado(transferencia.getEstado());
        dto.setImporte(transferencia.getImporte());
        dto.setCuentaOrigenId(transferencia.getCuentaOrigenId());
        dto.setCuentaDestinoId(transferencia.getCuentaDestinoId());
        dto.setFechaCreacion(transferencia.getFechaCreacion());
        return dto;
    }

    public static TransferenciaResponseDTOListado toListDTO(List<Transferencia> transferencias){
        List<TransferenciaResponseDTO> lista = transferencias.stream()
                .map(TransferenciaMapper::toDTO)
                .toList();

        TransferenciaResponseDTOListado response = new TransferenciaResponseDTOListado();
        response.setListaTransferencia(lista);

        return response;
    }

}
