package com.festibank.microservicio_cuenta.controller;

import com.festibank.microservicio_cuenta.dto.UsuarioDTO;
import com.festibank.microservicio_cuenta.dto.UsuarioRequestDTO;
import com.festibank.microservicio_cuenta.dto.UsuarioRequestDTOCreate;
import com.festibank.microservicio_cuenta.dto.UsuarioResponseDTO;
import com.festibank.microservicio_cuenta.service.IUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @GetMapping("/{id}")
    @Operation(description = "Obtiene un usuario con toda su información.")
    public ResponseEntity<UsuarioResponseDTO> detalle(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerUsuarioPorId(id));
    }

    @GetMapping
    @Operation(description = "Obtiene un usuario con toda la información a traves" +
            "del nombre y la contraseña.")
    public ResponseEntity<UsuarioResponseDTO> detallePorNombrePassword(
            @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(service.obtenerUsuarioPorNombreApellido(usuarioDTO));
    }

    @PostMapping
    @Operation(description = "Crea un usuario")
    public ResponseEntity<UsuarioResponseDTO> crear(
            @RequestBody UsuarioRequestDTOCreate usuarioRequestDTOCreate) {
        return new ResponseEntity<>(service.crear(usuarioRequestDTOCreate), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(description = "Edita un usuario entero , no edita nada de cuenta")
    public ResponseEntity<?>editar(@PathVariable Long id,
                                   @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        return ResponseEntity.ok(service.editar(id,usuarioRequestDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Elimina un determinado usuario por su Id")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
