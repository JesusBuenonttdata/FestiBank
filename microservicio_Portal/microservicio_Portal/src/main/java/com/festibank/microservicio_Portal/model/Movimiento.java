package com.festibank.microservicio_Portal.model;

import com.festibank.microservicio_Portal.utils.TipoMovimiento;
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

    private String cuenta;
    private BigDecimal importe;
    private TipoMovimiento tipo;
    private String referencia;
    private LocalDateTime fechaCreacion;


}
