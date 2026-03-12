package com.festibank.microservicio_Movimiento.service.movimiento;

import com.festibank.microservicio_Movimiento.client.CuentaClientRest;
import com.festibank.microservicio_Movimiento.dto.comunicacion.CuentaDTO;
import com.festibank.microservicio_Movimiento.dto.comunicacion.CuentaRequestDTO;
import com.festibank.microservicio_Movimiento.dto.movimiento.MovimientoRequestDTO;
import com.festibank.microservicio_Movimiento.dto.movimiento.MovimientoResponseDTO;
import com.festibank.microservicio_Movimiento.dto.movimiento.MovimientoResponseListDTO;
import com.festibank.microservicio_Movimiento.mapper.movimiento.MovimientoMapper;
import com.festibank.microservicio_Movimiento.model.Movimiento;
import com.festibank.microservicio_Movimiento.repository.MovimientoRepository;
import com.festibank.microservicio_Movimiento.utils.TipoMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimientoService implements IMovimientoService {

    @Autowired
    private MovimientoRepository repository;

    @Autowired
    private CuentaClientRest cuenta;

    @Override
    public MovimientoResponseDTO detalleId(Long id) {
        Movimiento movimiento = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "El movimiento no existe"));

        return MovimientoMapper.toDTO(movimiento);
    }

    @Override
    public MovimientoResponseListDTO listar(Long cuentaId) {
        List<Movimiento> movimientos =
                repository.findByCuentaIdOrderByFechaCreacionDesc(cuentaId);

        return MovimientoMapper.toListDTO(movimientos);
    }

    @Override
    public MovimientoResponseDTO credito(MovimientoRequestDTO request, Long cuentaId) {
        CuentaRequestDTO cuentaRequestDTO = new CuentaRequestDTO(request.getNombre(),request.getPassword());
        CuentaDTO cuentaModificada = cuenta.detallePorNombrePassword(cuentaRequestDTO);
        Movimiento movimiento = new Movimiento();

        BigDecimal saldoSumado = cuentaModificada.getSaldo().add(request.getImporte());
        cuentaModificada.setSaldo(saldoSumado);

        cuenta.editarSaldo(cuentaId,saldoSumado);

        movimiento.setCuentaId(cuentaId);
        movimiento.setTipo(TipoMovimiento.CREDITO);
        movimiento.setImporte(request.getImporte());
        movimiento.setReferencia("Manualmente...Se modificará en futuro");
        movimiento.setFechaCreacion(LocalDateTime.now());

        Movimiento nuevoMovimiento =repository.save(movimiento);

        return MovimientoMapper.toDTO(nuevoMovimiento);
    }

    @Override
    public MovimientoResponseDTO debito(MovimientoRequestDTO request, Long cuentaId) {
        CuentaRequestDTO cuentaRequestDTO = new CuentaRequestDTO(request.getNombre(),request.getPassword());
        CuentaDTO cuentaModificada = cuenta.detallePorNombrePassword(cuentaRequestDTO);

        if (cuentaModificada.getSaldo().compareTo(request.getImporte()) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST ,
                    "Saldo insuficiente");
        }

        Movimiento movimiento = new Movimiento();

        BigDecimal saldoRestar = cuentaModificada.getSaldo().subtract(request.getImporte());
        cuentaModificada.setSaldo(saldoRestar);

        cuenta.editarSaldo(cuentaId,saldoRestar);

        movimiento.setCuentaId(cuentaId);
        movimiento.setTipo(TipoMovimiento.DEBITO);
        movimiento.setImporte(request.getImporte());
        movimiento.setReferencia("Manualmente...Se modificará en futuro");
        movimiento.setFechaCreacion(LocalDateTime.now());

        Movimiento nuevoMovimiento =repository.save(movimiento);

        return MovimientoMapper.toDTO(nuevoMovimiento);
    }
}
