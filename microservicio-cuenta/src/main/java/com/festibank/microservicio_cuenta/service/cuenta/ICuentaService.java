package com.festibank.microservicio_cuenta.service.cuenta;

import com.festibank.microservicio_cuenta.dto.cuenta.*;
import com.festibank.microservicio_cuenta.dto.usuario.UsuarioRequestDTOCreate;
import com.festibank.microservicio_cuenta.model.Usuario;

public interface ICuentaService {

    CuentaResponseDTOView detallePorId (Long id);
    CuentaResponseDTO detallePorNombrePassword(CuentaDTO cuentaDTO);
    CuentaResponseDTO crear (CuentaRequestDTOCreate cuentaRequestDTOCreate, Usuario usuario);
    CuentaResponseDTO editar(Long id , CuentaRequestDTO cuentaRequestDTO);
    void eliminar (Long id);
}
