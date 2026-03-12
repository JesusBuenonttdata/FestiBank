package com.festibank.microservicio_Movimiento.dto.movimiento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoResponseListDTO {

    List<MovimientoResponseDTO> listaMovimiento;
}
