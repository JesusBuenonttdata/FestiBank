package com.festibank.microservicio_Movimiento.dto.transferencia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaDTOListado {

    String nombreCuenta;
    List<TransferenciaDTO> listaTransferencia;
}
