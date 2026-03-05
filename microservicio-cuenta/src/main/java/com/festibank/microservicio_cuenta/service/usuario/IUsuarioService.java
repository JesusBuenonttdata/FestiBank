package com.festibank.microservicio_cuenta.service.usuario;

import com.festibank.microservicio_cuenta.dto.usuario.*;

public interface IUsuarioService {

    UsuarioResponseDTODetalle obtenerUsuarioPorId(Long id);
    UsuarioResponseDTODetalle obtenerUsuarioPorNombreApellido(UsuarioDTO usuarioDTO);
    UsuarioResponseDTO crear(UsuarioRequestDTOCreate usuarioRequestDTOCreate);
    UsuarioResponseDTO editar(Long id,UsuarioRequestDTO usuarioRequestDTO);
    void eliminar (Long id);



}
