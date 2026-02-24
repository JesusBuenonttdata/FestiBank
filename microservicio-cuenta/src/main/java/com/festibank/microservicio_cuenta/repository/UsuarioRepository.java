package com.festibank.microservicio_cuenta.repository;

import com.festibank.microservicio_cuenta.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
