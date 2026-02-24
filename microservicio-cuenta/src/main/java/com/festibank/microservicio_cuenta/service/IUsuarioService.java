package com.festibank.microservicio_cuenta.service;

import com.festibank.microservicio_cuenta.dto.UsuarioDTO;
import com.festibank.microservicio_cuenta.dto.UsuarioRequestDTO;
import com.festibank.microservicio_cuenta.dto.UsuarioRequestDTOCreate;
import com.festibank.microservicio_cuenta.dto.UsuarioResponseDTO;

public interface IUsuarioService {

    UsuarioResponseDTO obtenerUsuarioPorId(Long id);
    UsuarioResponseDTO obtenerUsuarioPorNombreApellido(UsuarioDTO usuarioDTO);
    UsuarioResponseDTO crear(UsuarioRequestDTOCreate usuarioRequestDTOCreate);
    UsuarioResponseDTO editar(Long id,UsuarioRequestDTO usuarioRequestDTO);
    void eliminar (Long id);



}
