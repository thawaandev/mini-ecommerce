package com.thawanlc.mini_ecommerce.dto;

import java.math.BigDecimal;

import com.thawanlc.mini_ecommerce.entity.enums.FormaPagamento;
import com.thawanlc.mini_ecommerce.entity.enums.PedidoEnum;

public record PedidoRequest(
    Long clienteId,
    Long produtoId,
    int quantidade,
    FormaPagamento formaPagamento,
    BigDecimal desconto,
    PedidoEnum pedidoEnum
) {
    
}
