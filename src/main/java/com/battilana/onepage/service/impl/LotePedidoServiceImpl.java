package com.battilana.onepage.service.impl;

import com.battilana.onepage.dto.borradores.LotePedidosResponse;
import com.battilana.onepage.dto.borradores.PedidoDiarioResponse;
import com.battilana.onepage.dto.facturas.FacturasPorCobrarClientResponse;
import com.battilana.onepage.entity.LotePedidosEntity;
import com.battilana.onepage.mappers.LotePedidoMapper;
import com.battilana.onepage.repository.LotePedidosRepository;
import com.battilana.onepage.service.BorradoresService;
import com.battilana.onepage.service.FacturaClienteClientService;
import com.battilana.onepage.service.LotePedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LotePedidoServiceImpl implements LotePedidoService {

    private final LotePedidosRepository lotePedidosRepository;
    private final BorradoresService borradoresService;
    private final LotePedidoMapper lotePedidoMapper;
    private final FacturaClienteClientService facturaClienteClientService;

    @Override
    public void registrar() {
        List<PedidoDiarioResponse> pedidoDiarioResponses = this.borradoresService.buscarPedidosDiarios();
        List<LotePedidosEntity> lotePedidoEntities = new ArrayList<>();

        if (pedidoDiarioResponses != null) {
            for (PedidoDiarioResponse pd : pedidoDiarioResponses) {
                List<FacturasPorCobrarClientResponse> listadoFacturas = this.facturaClienteClientService.buscarFacturasPorCobrarPorCliente(pd.cardCode());
                LotePedidosEntity lp = new LotePedidosEntity();
                lp.setCodCliente(pd.cardCode());
                lp.setNombre(pd.cardName());
                lp.setFechaCreacion(LocalDate.now());
                lp.setFechaRecorte(LocalDateTime.now());
                lp.setMontoTotal(pd.docTotalFC());
                lp.setLineaCredito(pd.creditLine());
                lp.setCondicionPago(pd.pymntGroup());
                lp.setMontoPorCobrar(pd.montoPorVencer());
                lp.setMontoVencido(pd.montoVencido());

                BigDecimal saldoContable = listadoFacturas.stream().filter(
                        f -> f.ruc().equalsIgnoreCase(pd.cardCode())
                ).map(FacturasPorCobrarClientResponse::saldo)
                                .reduce(BigDecimal.ZERO, BigDecimal::add);

                lp.setLineaCreditoUtilizada(
                        (saldoContable.divide(pd.creditLine(), 2, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100))
                );
                lp.setMora(BigDecimal.valueOf(100));
                lp.setNroFacturasVencidas(pd.facturasVencidas());
                lp.setFechaFacturaVencidaMasAntigua(pd.fechaVencida());
                lp.setEstado(true);

                List<FacturasPorCobrarClientResponse> lstFacturas = listadoFacturas.stream()
                                .filter(f -> {

                                });

                lotePedidoEntities.add(lp);
            }
        }
        this.lotePedidosRepository.saveAll(lotePedidoEntities);
    }

    @Override
    public List<LotePedidosResponse> listar() {
        return this.lotePedidoMapper.toListResponse(this.lotePedidosRepository.findByEstadoTrue());
    }
}
