package com.festibank.microservicio_Movimiento.service.transferencia;

import com.festibank.microservicio_Movimiento.dto.movimiento.MovimientoRequestDTO;
import com.festibank.microservicio_Movimiento.dto.transferencia.TransferenciaRequestDTOCreate;
import com.festibank.microservicio_Movimiento.dto.transferencia.TransferenciaResponseDTO;
import com.festibank.microservicio_Movimiento.dto.transferencia.TransferenciaResponseDTOListado;
import com.festibank.microservicio_Movimiento.mapper.transferencia.TransferenciaMapper;
import com.festibank.microservicio_Movimiento.model.Transferencia;
import com.festibank.microservicio_Movimiento.repository.TransferenciaRepository;
import com.festibank.microservicio_Movimiento.service.movimiento.IMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferenciaService implements ITransferenciaService{

    @Autowired
    private TransferenciaRepository repository;

    @Autowired
    private IMovimientoService movimientoService;

    @Override
    public TransferenciaResponseDTO detralleId(Long id) {
        Transferencia transferencia = repository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "El movimiento no existe"));

        return TransferenciaMapper.toDTO(transferencia);
    }

    @Override
    public TransferenciaResponseDTOListado listadoPorCuentaId(Long cuentaId) {
        List<Transferencia> transferencias =
                repository.findByCuentaIdOrderByFechaCreacionDesc(cuentaId);

        return TransferenciaMapper.toListDTO(transferencias);
    }

    @Override
    public TransferenciaResponseDTO crear(TransferenciaRequestDTOCreate dtoCreate) {
        // Validar importe
        if (dtoCreate.getImporte().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "El importe debe ser mayor que cero");
        }

        // No permitir misma cuenta
        if (dtoCreate.getCuentaOrigenId().equals(dtoCreate.getCuentaDestinoId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "La cuenta origen y destino no pueden ser la misma");
        }

        // Construir request para reutilizar tu lógica actual
        MovimientoRequestDTO movimientoRequest =
                new MovimientoRequestDTO(
                        dtoCreate.getImporte(),
                        dtoCreate.getNombre(),
                        dtoCreate.getPassword()
                );

        // Realizar débito (valida saldo automáticamente)
        movimientoService.debito(movimientoRequest, dtoCreate.getCuentaOrigenId());

        // Realizar crédito
        movimientoService.credito(movimientoRequest, dtoCreate.getCuentaDestinoId());

        // Crear entidad transferencia
        Transferencia transferencia = new Transferencia();
        transferencia.setCuentaOrigenId(dtoCreate.getCuentaOrigenId());
        transferencia.setCuentaDestinoId(dtoCreate.getCuentaDestinoId());
        transferencia.setImporte(dtoCreate.getImporte());
        transferencia.setClaveIdempotencia(dtoCreate.getReferencia());
        transferencia.setFechaCreacion(LocalDateTime.now());

        Transferencia guardada = repository.save(transferencia);

        // Mapear a DTO
        return TransferenciaMapper.toDTO(guardada);
    }

    @Override
    public void cancelarTransferencia(Long id) {
        repository.deleteById(id);
    }
}
