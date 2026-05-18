package com.battilana.onepage.service.impl;

import com.battilana.onepage.dto.borradores.LotePedidosResponse;
import com.battilana.onepage.dto.borradores.PedidoDiarioResponse;
import com.battilana.onepage.entity.LotePedidosEntity;
import com.battilana.onepage.mappers.LotePedidoMapper;
import com.battilana.onepage.repository.LotePedidosRepository;
import com.battilana.onepage.service.BorradoresService;
import com.battilana.onepage.service.LotePedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    @Override
    public void registrar() {
        List<PedidoDiarioResponse> pedidoDiarioResponses = this.borradoresService.buscarPedidosDiarios();
        List<LotePedidosEntity> lotePedidoEntities = new ArrayList<>();
        if (pedidoDiarioResponses != null) {
            for (PedidoDiarioResponse pd : pedidoDiarioResponses) {
                LotePedidosEntity lp = new LotePedidosEntity();
                lp.setCodCliente(pd.cardCode());
                lp.setNombres(pd.cardName());
                lp.setFechaRecorte(LocalDateTime.now());
                lp.setFechaCreacion(LocalDate.now());
                lp.setEstado(true);
                lp.setCondicionDePago(pd.pymntGroup());
                lp.setMontoTotalPedido(pd.docTotalFC());
                lp.setLimiteCredito(pd.creditLine());
                lp.setMontoVencido(pd.montoVencido());
                lp.setMontoPorVencer(pd.montoPorVencer());
                lp.setFacturasVencidas(pd.facturasVencidas());
                lp.setFacturaVencida(pd.fechaVencida());
                lp.setFacturaPagada(pd.docDate());

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
