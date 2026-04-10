package com.battilana.onepage.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record LotePedidoRequest(
        String codCliente,
        String nombres,
        String condicionDePago,
        BigDecimal montoTotalPedido,
        BigDecimal limiteCredito,
        BigDecimal montoVencido,
        BigDecimal montoPorVencer,
        Long facturasVencidas,
        LocalDateTime facturaVencida,
        LocalDateTime facturaPagada
) {
}
