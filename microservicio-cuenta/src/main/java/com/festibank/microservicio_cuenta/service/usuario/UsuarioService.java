package com.festibank.microservicio_cuenta.service.usuario;

import com.festibank.microservicio_cuenta.dto.cuenta.CuentaRequestDTOCreate;
import com.festibank.microservicio_cuenta.dto.usuario.UsuarioDTO;
import com.festibank.microservicio_cuenta.dto.usuario.UsuarioRequestDTO;
import com.festibank.microservicio_cuenta.dto.usuario.UsuarioRequestDTOCreate;
import com.festibank.microservicio_cuenta.dto.usuario.UsuarioResponseDTO;
import com.festibank.microservicio_cuenta.mapper.cuenta.CuentaMapper;
import com.festibank.microservicio_cuenta.mapper.usuario.UsuarioMapper;
import com.festibank.microservicio_cuenta.model.Cuenta;
import com.festibank.microservicio_cuenta.model.Usuario;
import com.festibank.microservicio_cuenta.repository.UsuarioRepository;
import com.festibank.microservicio_cuenta.service.cuenta.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ICuentaService cuentaService;

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDTO obtenerUsuarioPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND ,
                        "Dicho Usuario no existe"));

        return UsuarioMapper.toDTO(usuario);

    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDTO obtenerUsuarioPorNombreApellido(UsuarioDTO usuarioDTO) {
        Usuario usuario = repository.findByNombreAndPassword(usuarioDTO.getNombreCuenta(),
                        usuarioDTO.getPassword())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND ,
                        "Dicho Usuario no existe"));

        return UsuarioMapper.toDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO crear(UsuarioRequestDTOCreate usuarioDTOCreate) {
        Usuario usuario = new Usuario();
        List<Cuenta> cuentaList = new ArrayList<>();

        usuario.setNombre(usuarioDTOCreate.getNombre());
        usuario.setApellidos(usuarioDTOCreate.getApellidos());
        usuario.setEmail(usuarioDTOCreate.getEmail());
        usuario.setLocalidad(usuarioDTOCreate.getLocalidad());
        usuario.setPais(usuarioDTOCreate.getPais());
        usuario.setPassword(usuarioDTOCreate.getPassword());
        usuario.setTelefono(usuarioDTOCreate.getTelefono());
        usuario.setFechaNacimiento(usuarioDTOCreate.getFechaNacimiento());

        Usuario nuevoUsuario = repository.save(usuario);

        CuentaRequestDTOCreate cuentaCreate = new CuentaRequestDTOCreate();
        cuentaCreate.setNombre(usuarioDTOCreate.getNombre());
        cuentaCreate.setTipo(usuarioDTOCreate.getTipoCuenta());
        cuentaService.crear(cuentaCreate , nuevoUsuario);
        cuentaList.add(CuentaMapper.toEntityCreate(cuentaCreate));

        return UsuarioMapper.toDTO(nuevoUsuario);
    }

    @Override
    public UsuarioResponseDTO editar(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND ,
                "Dicho Usuario no existe"));
        usuario.setNombre(usuarioRequestDTO.getNombre());
        usuario.setApellidos(usuarioRequestDTO.getApellidos());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setLocalidad(usuarioRequestDTO.getLocalidad());
        usuario.setPais(usuarioRequestDTO.getPais());
        usuario.setTelefono(usuarioRequestDTO.getTelefono());

        Usuario usuarioModificado = repository.save(usuario);

        return UsuarioMapper.toDTO(usuarioModificado);
    }

    @Override
    public void eliminar(Long id) {

        cuentaService.eliminar(id);
        repository.deleteById(id);
    }
}
