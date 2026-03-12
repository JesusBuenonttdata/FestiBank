package com.festibank.microservicio_Movimiento.mapper.movimiento;

import com.festibank.microservicio_Movimiento.dto.movimiento.MovimientoResponseDTO;
import com.festibank.microservicio_Movimiento.dto.movimiento.MovimientoResponseListDTO;
import com.festibank.microservicio_Movimiento.model.Movimiento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovimientoMapper {

    public static MovimientoResponseDTO toDTO(Movimiento movimiento){
        MovimientoResponseDTO dto = new MovimientoResponseDTO();
        dto.setCuentaId(movimiento.getCuentaId());
        dto.setTipo(movimiento.getTipo());
        dto.setReferencia(movimiento.getReferencia());
        dto.setImporte(movimiento.getImporte());
        dto.setFechaCreacion(movimiento.getFechaCreacion());
        return dto;
    }

    public static MovimientoResponseListDTO toListDTO(List<Movimiento> movimientos) {
        List<MovimientoResponseDTO> lista = movimientos.stream()
                .map(MovimientoMapper::toDTO)
                .toList();

        MovimientoResponseListDTO response = new MovimientoResponseListDTO();
        response.setListaMovimiento(lista);

        return response;
    }
}
