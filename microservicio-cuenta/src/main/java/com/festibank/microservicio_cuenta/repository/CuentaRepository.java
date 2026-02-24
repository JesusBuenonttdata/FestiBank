package com.festibank.microservicio_cuenta.repository;

import com.festibank.microservicio_cuenta.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Long> {
}
