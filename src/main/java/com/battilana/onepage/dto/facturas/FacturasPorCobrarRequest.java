package com.battilana.onepage.dto.facturas;

import java.math.BigDecimal;

public record FacturasPorCobrarRequest(
        //String ruc, --AUTOMATICO
        String nombre,
        Integer documento,
        String comprobante,
        String emision,
        String vencimiento,
        String moneda,
        BigDecimal importe,
        BigDecimal saldo,
        String vendedor,
        //LocalDate fechaRegistro, --AUTOMATICO
        //Integer periodo, --AUTOMATICO
        BigDecimal lc
) {
}
