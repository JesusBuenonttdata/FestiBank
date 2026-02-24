package com.festibank.microservicio_cuenta.service.cuenta;

import com.festibank.microservicio_cuenta.dto.cuenta.CuentaDTO;
import com.festibank.microservicio_cuenta.dto.cuenta.CuentaRequestDTO;
import com.festibank.microservicio_cuenta.dto.cuenta.CuentaRequestDTOCreate;
import com.festibank.microservicio_cuenta.dto.cuenta.CuentaResponseDTO;

public interface ICuentaService {

    CuentaResponseDTO detallePorId (Long id);
    CuentaResponseDTO detallePorNombrePassword(CuentaDTO cuentaDTO);
    CuentaResponseDTO crear (CuentaRequestDTOCreate cuentaRequestDTOCreate);
    CuentaResponseDTO editar(Long id , CuentaRequestDTO cuentaRequestDTO);
    void eliminar (Long id);
}
