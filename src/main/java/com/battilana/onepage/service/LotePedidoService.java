package com.battilana.onepage.service;

import com.battilana.onepage.dto.LotePedidoRequest;
import com.battilana.onepage.dto.LotePedidosResponse;

import java.util.List;

public interface LotePedidoService {

    void registrar();
    List<LotePedidosResponse> listar();
}
