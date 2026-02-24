package com.festibank.microservicio_cuenta.service.usuario;

import com.festibank.microservicio_cuenta.dto.usuario.UsuarioDTO;
import com.festibank.microservicio_cuenta.dto.usuario.UsuarioRequestDTO;
import com.festibank.microservicio_cuenta.dto.usuario.UsuarioRequestDTOCreate;
import com.festibank.microservicio_cuenta.dto.usuario.UsuarioResponseDTO;

public interface IUsuarioService {

    UsuarioResponseDTO obtenerUsuarioPorId(Long id);
    UsuarioResponseDTO obtenerUsuarioPorNombreApellido(UsuarioDTO usuarioDTO);
    UsuarioResponseDTO crear(UsuarioRequestDTOCreate usuarioRequestDTOCreate);
    UsuarioResponseDTO editar(Long id,UsuarioRequestDTO usuarioRequestDTO);
    void eliminar (Long id);



}
