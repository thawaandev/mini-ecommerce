package com.thawanlc.mini_ecommerce.mapper;

import java.util.ArrayList;
import java.util.List;

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

    public static List<PedidoResponse> toDto(List<Pedido> lista) {

        List<PedidoResponse> l = new ArrayList<>();

        for(Pedido p : lista) {
            PedidoResponse pr = toResponse(p);

            l.add(pr);
        }

        return l;
    }

}
