package com.festibank.microservicio_Movimiento.model;

import com.festibank.microservicio_Movimiento.utils.EstadoTransferencia;
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
@Table(name = "transferencias")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String cuentaOrigen;
    private String cuentaDestino;
    private BigDecimal importe;
    private EstadoTransferencia estado;
    private String claveIdempotencia;
    private LocalDateTime fechaCreacion;
}
