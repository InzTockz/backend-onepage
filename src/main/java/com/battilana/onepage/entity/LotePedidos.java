package com.battilana.onepage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LotePedidos {

    private Integer idLotePedidos;
    private String codCliente;
    private String nombres;
    private String condicionDePago;
    private BigDecimal montoTotalPedido;
    private BigDecimal limiteCredito;
    private LocalDate fechaRecorte;
    private LocalDate fechaCreacion;
    private Boolean estado;
}
