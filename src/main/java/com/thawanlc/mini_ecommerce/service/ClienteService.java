package com.thawanlc.mini_ecommerce.service;

import java.util.List;

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
        return clienteRepository.saveAndFlush(criarCliente);

    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }


}
