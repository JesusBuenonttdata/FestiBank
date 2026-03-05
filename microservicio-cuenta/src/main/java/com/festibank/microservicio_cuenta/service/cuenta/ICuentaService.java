package com.festibank.microservicio_cuenta.service.cuenta;

import com.festibank.microservicio_cuenta.dto.cuenta.*;
import com.festibank.microservicio_cuenta.model.Usuario;

import java.math.BigDecimal;

public interface ICuentaService {

    CuentaResponseDTOView detallePorId (Long id);
    CuentaResponseDTO detallePorNombrePassword(CuentaDTO cuentaDTO);
    CuentaResponseDTO crear(CuentaRequestDTOCreate cuentaRequestDTOCreate, Usuario usuario);
    CuentaResponseDTO crearPorIdUsuario(CuentaRequestDTOCreate cuentaRequestDTOCreate, Long id);
    CuentaResponseDTO editar(Long id , CuentaRequestDTO cuentaRequestDTO);
    CuentaResponseDTO editarSaldo(Long id, BigDecimal dinero);
    void eliminar (Long id);
}
