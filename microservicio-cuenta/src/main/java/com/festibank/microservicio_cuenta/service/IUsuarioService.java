package com.festibank.microservicio_cuenta.service;

import com.festibank.microservicio_cuenta.dto.UsuarioRequestDTO;
import com.festibank.microservicio_cuenta.dto.UsuarioRequestDTOCreate;
import com.festibank.microservicio_cuenta.dto.UsuarioResponseDTO;

public interface IUsuarioService {

    UsuarioResponseDTO obtenerUsuarioPorId(Long id);
    UsuarioResponseDTO obtenerUsuarioPorNombreApellido(String nombre , String apellido);
    UsuarioResponseDTO crear(UsuarioRequestDTOCreate usuarioRequestDTOCreate);
    UsuarioResponseDTO editar(UsuarioRequestDTO usuarioRequestDTO);
    void eliminar (Long id);


}
