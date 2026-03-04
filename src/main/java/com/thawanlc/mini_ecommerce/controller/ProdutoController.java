package com.thawanlc.mini_ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thawanlc.mini_ecommerce.entity.Produto;
import com.thawanlc.mini_ecommerce.service.ProdutoService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Void> salvarProduto(@Valid @RequestBody Produto produto) {
        produtoService.criarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    } 

    @GetMapping
    public List<Produto> listarAll() {
        return produtoService.listarTodos();
    }

    @GetMapping("/filtrar/{nome}")
    public ResponseEntity<?> filtrar(@PathVariable String nome) {
        try {
            List<Produto> produtos = produtoService.filtrarPorNome(nome);

            if(produtos == null || produtos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
            }

            if(nome == null || nome.isBlank() || nome.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nome produto não encontrado" + nome);
            }

            return ResponseEntity.status(HttpStatus.FOUND).body(produtos);

        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno: " + e.getMessage());
        }
    }

}
