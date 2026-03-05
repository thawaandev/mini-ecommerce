package com.thawanlc.mini_ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thawanlc.mini_ecommerce.dto.PedidoRequest;
import com.thawanlc.mini_ecommerce.dto.PedidoResponse;
import com.thawanlc.mini_ecommerce.entity.Pedido;
import com.thawanlc.mini_ecommerce.service.PedidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Void> salvarPedido(@RequestBody PedidoRequest request) {
        pedidoService.criarPedido(request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping
    public List<PedidoResponse> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/filtrar/{nome}")
    public ResponseEntity<?> filtrar(@PathVariable String nome) {
        try {
            List<Pedido> lista = pedidoService.filtrarPorCliente(nome);

            if(lista == null || lista.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
            }

            if(nome == null || nome.isBlank() || nome.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sem conteúdo" + nome);
            }

            return ResponseEntity.status(HttpStatus.FOUND).body(lista);

        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno: " + e.getMessage());
        }
    }
    
    
}
