package com.festibank.microservicio_cuenta.controller;

import com.festibank.microservicio_cuenta.dto.cuenta.CuentaDTO;
import com.festibank.microservicio_cuenta.dto.cuenta.CuentaRequestDTO;
import com.festibank.microservicio_cuenta.dto.cuenta.CuentaRequestDTOCreate;
import com.festibank.microservicio_cuenta.dto.cuenta.CuentaResponseDTO;
import com.festibank.microservicio_cuenta.service.cuenta.ICuentaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController("/cuenta")
public class CuentaController {

    @Autowired
    private ICuentaService service;

    @GetMapping("/{id}")
    @Operation(description = "Obtiene una cuenta con toda su información.")
    public ResponseEntity<CuentaResponseDTO> detalle(@PathVariable Long id) {
        return ResponseEntity.ok(service.detallePorId(id));
    }

    @GetMapping
    @Operation(description = "Obtiene una cuenta con toda la información a traves" +
            "del nombre y la contraseña.")
    public ResponseEntity<CuentaResponseDTO> detallePorNombrePassword(
            @RequestBody CuentaDTO cuentaDTO) {
        return ResponseEntity.ok(service.detallePorNombrePassword(cuentaDTO));
    }

    @PostMapping
    @Operation(description = "Crea una cuenta")
    public ResponseEntity<CuentaResponseDTO> crear(
            @RequestBody CuentaRequestDTOCreate cuentaRequestDTOCreate) {
        return new ResponseEntity<>(service.crear(cuentaRequestDTOCreate), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(description = "Edita una cuenta solo password y estado")
    public ResponseEntity<?>editar(@PathVariable Long id,
                                   @RequestBody CuentaRequestDTO cuentaRequestDTO){
        return ResponseEntity.ok(service.editar(id,cuentaRequestDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Elimina una determinada cuenta por su Id")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
