package com.festibank.microservicio_Movimiento.dto.comunicacion;

import com.festibank.microservicio_Movimiento.utils.EstadoCuenta;
import com.festibank.microservicio_Movimiento.utils.TipoCuenta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDTO {

    private Long id;
    private String nombre;
//    private int password;
    private String iban;
    private TipoCuenta tipo;
    private EstadoCuenta estado;
    private BigDecimal saldo ;
}
