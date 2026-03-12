package com.festibank.microservicio_cuenta.mapper.cuenta;

import com.festibank.microservicio_cuenta.dto.cuenta.CuentaRequestDTO;
import com.festibank.microservicio_cuenta.dto.cuenta.CuentaRequestDTOCreate;
import com.festibank.microservicio_cuenta.dto.cuenta.CuentaResponseDTO;
import com.festibank.microservicio_cuenta.dto.cuenta.CuentaResponseDTOView;
import com.festibank.microservicio_cuenta.model.Cuenta;
import org.springframework.stereotype.Component;

@Component
public class CuentaMapper {

    public static CuentaResponseDTO toDTO(Cuenta cuenta){
        CuentaResponseDTO dto =new CuentaResponseDTO();
        dto.setNombre(cuenta.getNombre());
        dto.setTipo(cuenta.getTipo());
        dto.setEstado(cuenta.getEstado());
        dto.setIban(cuenta.getIban());
        dto.setSaldo(cuenta.getSaldo());
        return dto;
    }

    public static CuentaResponseDTOView toDTOView(Cuenta cuenta){
        CuentaResponseDTOView dtoView = new CuentaResponseDTOView();
        dtoView.setNombre(cuenta.getNombre());
        dtoView.setPassword(cuenta.getPassword());

        return dtoView;
    }

    public  static Cuenta toEntityCreate (CuentaRequestDTOCreate dtoCreate){
        Cuenta entity = new Cuenta();
        entity.setNombre(dtoCreate.getNombre());
        entity.setTipo(dtoCreate.getTipo());
        return entity;
    }
}
