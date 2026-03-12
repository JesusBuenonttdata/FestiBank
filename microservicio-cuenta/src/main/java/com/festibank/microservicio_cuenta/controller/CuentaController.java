package com.festibank.microservicio_cuenta.controller;

import com.festibank.microservicio_cuenta.dto.cuenta.*;
import com.festibank.microservicio_cuenta.service.cuenta.ICuentaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private ICuentaService service;

    @GetMapping("/{id}")
    @Operation(description = "Obtiene una cuenta con toda su información.")
    public ResponseEntity<CuentaResponseDTOView> detalle(@PathVariable Long id) {
        return ResponseEntity.ok(service.detallePorId(id));
    }

    @PostMapping
    @Operation(description = "Obtiene una cuenta con toda la información a traves" +
            "del nombre y la contraseña.")
    public ResponseEntity<CuentaResponseDTO> detallePorNombrePassword(
            @RequestBody CuentaDTO cuentaDTO) {
        return ResponseEntity.ok(service.detallePorNombrePassword(cuentaDTO));
    }

    @PostMapping("/{id}")
    @Operation(description = "Crea una cuenta")
    public ResponseEntity<CuentaResponseDTO> crear(
            @PathVariable Long id,
            @RequestBody CuentaRequestDTOCreate cuentaRequestDTOCreate) {
        return new ResponseEntity<>(service.crearPorIdUsuario(cuentaRequestDTOCreate , id),
        HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(description = "Edita una cuenta solo password y estado")
    public ResponseEntity<?>editar(@PathVariable Long id,
                                   @RequestBody CuentaRequestDTO cuentaRequestDTO){
        return ResponseEntity.ok(service.editar(id,cuentaRequestDTO));
    }

    @PutMapping("/saldo/{id}")
    @Operation(description = "Edita el dinero de una determinada cuenta")
    public ResponseEntity<?> editarSaldo(@PathVariable Long id,
                                         @RequestBody BigDecimal dinero){

        return ResponseEntity.ok(service.editarSaldo(id , dinero));
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Elimina una determinada cuenta por su Id")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
