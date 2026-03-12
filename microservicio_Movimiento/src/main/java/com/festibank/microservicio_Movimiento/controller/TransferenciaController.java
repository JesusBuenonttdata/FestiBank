package com.festibank.microservicio_Movimiento.controller;

import com.festibank.microservicio_Movimiento.dto.transferencia.TransferenciaRequestDTOCreate;
import com.festibank.microservicio_Movimiento.dto.transferencia.TransferenciaResponseDTO;
import com.festibank.microservicio_Movimiento.dto.transferencia.TransferenciaResponseDTOListado;
import com.festibank.microservicio_Movimiento.service.transferencia.ITransferenciaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    @Autowired
    private ITransferenciaService service;

    @GetMapping("/{id}")
    @Operation(description = "Obtiene toda la información de una transferencia determinada")
    public ResponseEntity<TransferenciaResponseDTO> detalleId(@PathVariable Long id){
        return ResponseEntity.ok(service.detralleId(id));
    }

    @GetMapping("/{cuentaId}/cuenta")
    @Operation(description = "Obtiene toda las transferencia de una cuenta determinada")
    public ResponseEntity<TransferenciaResponseDTOListado> listadoPorCuentaId(@PathVariable Long cuentaId){
        return ResponseEntity.ok(service.listadoPorCuentaId(cuentaId));
    }

    @PostMapping
    @Operation(description = "Crea una transferencia")
    public ResponseEntity<TransferenciaResponseDTO> crear (@RequestBody TransferenciaRequestDTOCreate transferDTOCreate){
        return ResponseEntity.ok(service.crear(transferDTOCreate));
    }

    @DeleteMapping("/{id}")
    @Operation(description = "elimina una transferencia determinada")
    public ResponseEntity<Void> eliminar (@PathVariable Long id){
        service.cancelarTransferencia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
    }

}
