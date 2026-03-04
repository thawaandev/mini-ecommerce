package com.thawanlc.mini_ecommerce.mapper;

import com.thawanlc.mini_ecommerce.dto.PedidoResponse;
import com.thawanlc.mini_ecommerce.entity.Pedido;

public class PedidoMapper {
    
    public static PedidoResponse toResponse(Pedido p) {
        return new PedidoResponse(
            p.getCliente().getNome(),
            p.getProduto().getNome(),
            p.getQuantidade(),
            p.getFormaPagamento(),
            p.getTotal(),
            p.getDesconto()
        );
    }

}
