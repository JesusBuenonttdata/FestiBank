package com.festibank.microservicio_cuenta.repository;

import com.festibank.microservicio_cuenta.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Long> {

    Optional<Cuenta> findByNombreAndPassword(String nombre , String password);
}
