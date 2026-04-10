package com.battilana.onepage.mappers;

import com.battilana.onepage.dto.LotePedidoRequest;
import com.battilana.onepage.dto.LotePedidosResponse;
import com.battilana.onepage.entity.LotePedidos;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LotePedidoMapper {

    List<LotePedidosResponse> toListResponse(List<LotePedidos> lotePedidos);
    LotePedidosResponse toRegisterResponse(LotePedidos lotePedidos);
    @InheritInverseConfiguration
    LotePedidos toLoteEntity(LotePedidoRequest lotePedidoRequest);
}
