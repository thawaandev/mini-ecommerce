package com.thawanlc.mini_ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thawanlc.mini_ecommerce.entity.Cliente;
import com.thawanlc.mini_ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente) {

        Cliente criarCliente = new Cliente();
        criarCliente.setNome(cliente.getNome());
        criarCliente.setDesconto(cliente.getDesconto());
        return clienteRepository.saveAndFlush(criarCliente);

    }


}
