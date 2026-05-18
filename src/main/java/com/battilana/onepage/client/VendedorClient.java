package com.battilana.onepage.client;

import com.battilana.onepage.dto.vendedor.VendedorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "Vendedor-service", url = "http://localhost:8082/api/v2/vendedores")
public interface VendedorClient {

    @RequestMapping(method = RequestMethod.GET, value = "")
    List<VendedorResponse> listaVendedores();
}
