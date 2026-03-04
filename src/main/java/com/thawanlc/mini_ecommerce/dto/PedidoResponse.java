package com.thawanlc.mini_ecommerce.dto;

import java.math.BigDecimal;

import com.thawanlc.mini_ecommerce.entity.enums.FormaPagamento;


public record PedidoResponse(
    String nomeCliente,
    String nomeProduto,
    int quantidade,
    FormaPagamento formaPagamento,
    BigDecimal total,
    BigDecimal desconto
) {
    
}
