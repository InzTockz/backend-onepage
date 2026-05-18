package com.battilana.onepage.client;

import com.battilana.onepage.dto.cliente.ClienteClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "Client-service", url = "http://localhost:8082/api/v2/clientes")
public interface ClienteClient {

    @RequestMapping(method = RequestMethod.GET, value = "")
    List<ClienteClientResponse> listarClientes();

    @RequestMapping(method = RequestMethod.GET, value = "/vendedor/{idVendedor}")
    List<ClienteClientResponse> listarClientePorIdVendedor(@PathVariable Integer idVendedor);
}
