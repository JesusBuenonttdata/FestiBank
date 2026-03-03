package com.festibank.microservicio_cuenta.mapper.usuario;

import com.festibank.microservicio_cuenta.dto.usuario.UsuarioDTO;
import com.festibank.microservicio_cuenta.dto.usuario.UsuarioRequestDTOCreate;
import com.festibank.microservicio_cuenta.dto.usuario.UsuarioResponseDTO;
import com.festibank.microservicio_cuenta.model.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UsuarioMapper {

    public static UsuarioResponseDTO toDTO (Usuario usuario){
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setNombre(usuario.getNombre());
        dto.setApellidos(usuario.getApellidos());
        dto.setFechaNacimiento(usuario.getFechaNacimiento());
        dto.setLocalidad(usuario.getLocalidad());
        dto.setPais(usuario.getPais());
        dto.setEmail(usuario.getEmail());
        dto.setTelefono(usuario.getTelefono());

        return dto;
    }

    public static  Usuario toEntityCreate (UsuarioRequestDTOCreate usuarioRequestDTOCreate){
        Usuario entityCreate = new Usuario();
        entityCreate.setNombre(usuarioRequestDTOCreate.getNombre());
        entityCreate.setApellidos(usuarioRequestDTOCreate.getApellidos());
        entityCreate.setPassword(usuarioRequestDTOCreate.getPassword());
        entityCreate.setEmail(usuarioRequestDTOCreate.getEmail());
        entityCreate.setTelefono(usuarioRequestDTOCreate.getTelefono());
        entityCreate.setPais(usuarioRequestDTOCreate.getPais());
        entityCreate.setLocalidad(usuarioRequestDTOCreate.getLocalidad());
        entityCreate.setFechaNacimiento(usuarioRequestDTOCreate.getFechaNacimiento());
        return entityCreate;
    }
}
