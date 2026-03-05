package com.festibank.microservicio_Movimiento.repository;

import com.festibank.microservicio_Movimiento.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia,Long> {
}
