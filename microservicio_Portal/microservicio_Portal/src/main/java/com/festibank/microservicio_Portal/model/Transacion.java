package com.festibank.microservicio_Portal.model;

import com.festibank.microservicio_Portal.utils.EstadoTransferencia;
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
@Table(name = "transiciones")
public class Transacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String cuentaOrigen; //cambiar el tipo
    private String cuentaDestino; //cambiar el tipo
    private BigDecimal importe;
    private EstadoTransferencia estado;
    private String claveIdempotencia;
    private LocalDateTime fechaCreacion;


}
