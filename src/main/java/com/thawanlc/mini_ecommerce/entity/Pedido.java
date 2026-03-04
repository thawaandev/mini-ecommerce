package com.thawanlc.mini_ecommerce.entity;

import com.thawanlc.mini_ecommerce.entity.enums.PedidoEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Cliente cliente;

    private Produto produto;

    private int quantidade;

    private String formaPagamento;

    private PedidoEnum pedidoEnum;


}
