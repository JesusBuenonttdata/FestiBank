package com.festibank.microservicio_Movimiento.model;

import com.festibank.microservicio_Movimiento.utils.TipoMovimiento;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private Long cuentaId;
    private BigDecimal importe;
    private TipoMovimiento tipo; // DEBITO o CREDITO
    private String referencia;
    private LocalDateTime fechaCreacion;


}
