package com.festibank.microservicio_Movimiento.client;

import com.festibank.microservicio_Movimiento.dto.comunicacion.CuentaDTO;
import com.festibank.microservicio_Movimiento.dto.comunicacion.CuentaRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@FeignClient(name = "microservicio-cuenta" , url = "${cuenta.client.url}")
public interface CuentaClientRest {

    @PostMapping("/cuenta")
    CuentaDTO detallePorNombrePassword(@RequestBody CuentaRequestDTO cuentaRequestDTO);

    @PutMapping("/cuenta/saldo/{id}")
     void editarSaldo(@PathVariable Long id, @RequestBody BigDecimal saldo);
}
