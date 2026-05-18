package com.battilana.onepage.service.impl;

import com.battilana.onepage.dto.facturas.FacturasPorCobrarResponse;
import com.battilana.onepage.dto.facturas.ResumenCarteraResponse;
import com.battilana.onepage.mappers.FacturaClienteMapper;
import com.battilana.onepage.repository.FacturaClienteRepository;
import com.battilana.onepage.service.FacturaClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacturaClienteServiceImpl implements FacturaClienteService {

    private final FacturaClienteRepository facturaClienteRepository;
    private final FacturaClienteMapper facturaClienteMapper;

    @Override
    public List<FacturasPorCobrarResponse> buscarFacturasPorAnioYPeriodo(Integer anio, Integer periodo) {
        return this.facturaClienteMapper.toListDto(this.facturaClienteRepository.buscarFacturasPorAnioYPeriodo(anio, periodo));
    }

    @Override
    public List<FacturasPorCobrarResponse> buscarFacturasPorAnio(Integer anio) {
        return this.facturaClienteMapper.toListDto(this.facturaClienteRepository.buscarFacturasPorAnio(anio));
    }

    @Override
    public List<ResumenCarteraResponse> resumenCartera() {
        return this.facturaClienteRepository.resumenCartera();
    }

    @Override
    public List<ResumenCarteraResponse> resumenCarteraPorPeriodo(Integer periodo) {
        return this.facturaClienteRepository.resumenCarteraPorPeriodo(periodo);
    }

    @Override
    public List<ResumenCarteraResponse> resumenCarteraPorPeriodoYVendedor(Integer periodo, String vendedor) {
        return this.facturaClienteRepository.resumenCarteraPorPeriodoYVendedor(periodo, vendedor);
    }

    @Override
    public List<ResumenCarteraResponse> resumenCarteraPorVendedor(String vendedor) {
        return this.facturaClienteRepository.resumenCarteraPorVendedor(vendedor);
    }
}
