package com.festibank.microservicio_Movimiento.repository;


import com.festibank.microservicio_Movimiento.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia,Long> {

    List<Transferencia> findByCuentaIdOrderByFechaCreacionDesc(Long cuentaId);
}
