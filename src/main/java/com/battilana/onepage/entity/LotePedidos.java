package com.battilana.onepage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_lote_pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LotePedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLotePedidos;
    private String codCliente;
    private String nombres;
    private String condicionDePago;
    private BigDecimal montoTotalPedido;
    private BigDecimal limiteCredito;
    @CreationTimestamp
    private LocalDate fechaRecorte;
    @CreationTimestamp
    private LocalDate fechaCreacion;
    private Boolean estado;
    private BigDecimal montoVencido;
    private BigDecimal montoPorVencer;
    private Long facturasVencidas;
    private LocalDateTime facturaVencida;
    private LocalDateTime facturaPagada;
}
