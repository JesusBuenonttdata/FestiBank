package com.festibank.microservicio_cuenta.service.cuenta;

import com.festibank.microservicio_cuenta.dto.cuenta.*;
import com.festibank.microservicio_cuenta.dto.usuario.UsuarioRequestDTOCreate;
import com.festibank.microservicio_cuenta.mapper.cuenta.CuentaMapper;
import com.festibank.microservicio_cuenta.mapper.usuario.UsuarioMapper;
import com.festibank.microservicio_cuenta.model.Cuenta;
import com.festibank.microservicio_cuenta.model.Usuario;
import com.festibank.microservicio_cuenta.repository.CuentaRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class CuentaService implements ICuentaService{

    @Autowired
    private CuentaRepository repository;

    @Override
    public CuentaResponseDTOView detallePorId(Long id) {
        Cuenta cuenta = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"La cuenta no existe"));
        return CuentaMapper.toDTOView(cuenta);
    }

    @Override
    public CuentaResponseDTO detallePorNombrePassword(CuentaDTO cuentaDTO) {
        Cuenta cuenta = repository.findByNombreAndPassword(cuentaDTO.getNombre(),
                        cuentaDTO.getPassword())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"La cuenta no existe"));
        return CuentaMapper.toDTO(cuenta);
    }

    @Override
    @Transactional
    public CuentaResponseDTO crear(CuentaRequestDTOCreate cuentaRequestDTOCreate ,
                                   Usuario usuario) {
        Cuenta cuenta = new Cuenta();
        Faker faker = new Faker();
        cuenta.setEstado("ACTIVO");
        cuenta.setIban(faker.finance().iban());
        cuenta.setTipo(cuentaRequestDTOCreate.getTipo());
        cuenta.setNombre(cuentaRequestDTOCreate.getNombre());
        cuenta.setPassword(faker.number().numberBetween(1000, 10000));
        cuenta.setSaldo(BigDecimal.valueOf(0));
        cuenta.setUsuario(usuario);
        Cuenta nuevaCuenta = repository.save(cuenta);

        return CuentaMapper.toDTO(nuevaCuenta);
    }

    @Override
    @Transactional
    public CuentaResponseDTO editar(Long id, CuentaRequestDTO cuentaRequestDTO) {
        Cuenta cuenta = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"La cuenta no existe"));

        cuenta.setPassword(cuentaRequestDTO.getPassword());
        cuenta.setEstado(cuentaRequestDTO.getEstado());

        Cuenta cuentaModificada = repository.save(cuenta);

        return CuentaMapper.toDTO(cuentaModificada);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
