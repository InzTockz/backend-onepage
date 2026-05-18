package com.battilana.onepage.service.impl;

import com.battilana.onepage.client.ClienteClient;
import com.battilana.onepage.dto.cliente.ClienteClientResponse;
import com.battilana.onepage.service.ClienteClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteClientServiceImpl implements ClienteClientService {

    private final ClienteClient clienteClient;

    @Override
    public List<ClienteClientResponse> listarClientes() {
        return this.clienteClient.listarClientes();
    }

    @Override
    public List<ClienteClientResponse> listarClientesPorIdVendedor(Integer idVendedor) {
        return this.clienteClient.listarClientePorIdVendedor(idVendedor);
    }
}
