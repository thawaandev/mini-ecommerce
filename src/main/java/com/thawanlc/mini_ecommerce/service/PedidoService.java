package com.thawanlc.mini_ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thawanlc.mini_ecommerce.dto.PedidoRequest;
import com.thawanlc.mini_ecommerce.dto.PedidoResponse;
import com.thawanlc.mini_ecommerce.entity.Pedido;
import com.thawanlc.mini_ecommerce.entity.enums.PedidoEnum;
import com.thawanlc.mini_ecommerce.mapper.PedidoMapper;
import com.thawanlc.mini_ecommerce.repository.PedidoRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;


    public PedidoResponse criarPedido(PedidoRequest request) {

        Pedido pedido = new Pedido();
        pedido.setCliente(request.clienteId());
        pedido.setProduto(request.produtoId());
        pedido.setQuantidade(request.quantidade());
        pedido.setFormaPagamento(request.formaPagamento());
        pedido.setTotal(null);
        pedido.setDesconto(request.desconto());
        pedido.setPedidoEnum(PedidoEnum.PENDENTE);
        pedidoRepository.saveAndFlush(pedido);

        return PedidoMapper.toResponse(pedido);
    }



}
