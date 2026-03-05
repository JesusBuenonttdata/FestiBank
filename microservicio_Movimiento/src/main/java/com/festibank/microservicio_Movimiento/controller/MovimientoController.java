package com.festibank.microservicio_Movimiento.controller;


import com.festibank.microservicio_Movimiento.dto.movimiento.MovimientoResponseDTO;
import com.festibank.microservicio_Movimiento.service.movimiento.IMovimientoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {

    @Autowired
    private IMovimientoService service;

    @GetMapping("/{id}")
    @Operation(description = "Obtiene toda la información de un movimiento determinado")
    public ResponseEntity<MovimientoResponseDTO> detalle(@PathVariable Long id){
        return ResponseEntity.ok(service.detalleId(id));
    }

    @GetMapping("/{cuentaId}/cuenta")
    @Operation(description = "Obtiene todos los movimiento de la cuenta")
    public ResponseEntity<List<MovimientoResponseDTO>> listar(@PathVariable Long cuentaId){
        return ResponseEntity.ok(service.listar(cuentaId));
    }

    @PutMapping("/{cuentaId}/credito")
    @Operation(description = "Se annade dinero a tu cuenta")
    public ResponseEntity<MovimientoResponseDTO> credito(@PathVariable Long cuentaId,
                                                         @RequestBody BigDecimal dinero){
        return ResponseEntity.ok(service.credito(dinero ,cuentaId));
    }

    @PutMapping("/{cuentaId}/debito")
    @Operation(description = "Se saca dinero a tu cuenta")
    public ResponseEntity<MovimientoResponseDTO> debito(@PathVariable Long cuentaId,
                                                        @RequestBody BigDecimal dinero){
        return ResponseEntity.ok(service.debito(dinero ,cuentaId));
    }


}
