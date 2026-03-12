package com.festibank.microservicio_Movimiento.repository;

import com.festibank.microservicio_Movimiento.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento,Long> {

    List<Movimiento> findByCuentaIdOrderByFechaCreacionDesc(Long cuentaId);
}
