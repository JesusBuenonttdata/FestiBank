package com.festibank.microservicio_cuenta.dto.cuenta;

import com.festibank.microservicio_cuenta.model.Usuario;
import com.festibank.microservicio_cuenta.utils.EstadoCuenta;
import com.festibank.microservicio_cuenta.utils.TipoCuenta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaResponseDTO {

    private String nombre;
    private String iban;
    private TipoCuenta tipo;
    private EstadoCuenta estado;
    private BigDecimal saldo;
}
