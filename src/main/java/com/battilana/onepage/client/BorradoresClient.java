package com.battilana.onepage.client;

import com.battilana.onepage.dto.PedidoDiarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "borrador-service", url = "http://localhost:8082/api/v2/borradores")
public interface BorradoresClient {

    @RequestMapping(method = RequestMethod.GET, value = "/pedidos-diario")
    List<PedidoDiarioResponse> buscarPedidosDiarios();
}
