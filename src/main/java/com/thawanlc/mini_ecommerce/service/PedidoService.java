package com.thawanlc.mini_ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thawanlc.mini_ecommerce.dto.PedidoRequest;
import com.thawanlc.mini_ecommerce.dto.PedidoResponse;
import com.thawanlc.mini_ecommerce.entity.Cliente;
import com.thawanlc.mini_ecommerce.entity.Pedido;
import com.thawanlc.mini_ecommerce.entity.Produto;
import com.thawanlc.mini_ecommerce.entity.enums.PedidoEnum;
import com.thawanlc.mini_ecommerce.mapper.PedidoMapper;
import com.thawanlc.mini_ecommerce.repository.ClienteRepository;
import com.thawanlc.mini_ecommerce.repository.PedidoRepository;
import com.thawanlc.mini_ecommerce.repository.ProdutoRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;


    public PedidoResponse criarPedido(PedidoRequest request) {

        if(request.clienteId() == null || request.produtoId() == null) {
            throw new NullPointerException("Algum dado está nullo");
        }

        Cliente cliente = clienteRepository.findById(request.clienteId()).orElseThrow(
            () -> new RuntimeException("Cliente não encontrado"));

        Produto produto = produtoRepository.findById(request.produtoId()).orElseThrow(
            () -> new RuntimeException("Produto não encontrado")
        );

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        pedido.setQuantidade(request.quantidade());
        pedido.setFormaPagamento(request.formaPagamento());
        pedido.setTotal(null);
        pedido.setDesconto(request.desconto());
        pedido.setPedidoEnum(PedidoEnum.PENDENTE);
        pedidoRepository.saveAndFlush(pedido);

        return PedidoMapper.toResponse(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> filtrarPorCliente(String nome) {
        List<Pedido> cliente = clienteRepository.findByNome(nome);
        
        if(nome == null || nome.isBlank()) {
            throw new NullPointerException("Nome não existente:");
        }

        if(cliente == null || cliente.isEmpty()) {
            throw new RuntimeException("Cliente não existente");
        }

        String nomeLower = nome.toLowerCase();

        return cliente.stream()
        .filter(c -> c.getCliente().getNome().toLowerCase().startsWith(nomeLower))
        .collect(Collectors.toList());

    }



}
