package com.thawanlc.mini_ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thawanlc.mini_ecommerce.entity.Produto;
import com.thawanlc.mini_ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Produto criarProduto(Produto produto) {

        Produto p = new Produto();
        p.setNome(produto.getNome());
        p.setPreco(produto.getPreco());
        p.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        produtoRepository.saveAndFlush(p);
        return p;

    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public List<Produto> filtrarPorNome(String nome) {
        List<Produto> listaProdutos = produtoRepository.findAll();
        if(nome == null || nome.isBlank()) {
            return listaProdutos;
        }

        if(listaProdutos == null) {
            throw new NullPointerException("Produto Nullo");
        }

        String nomeLower = nome.toLowerCase();

        return listaProdutos.stream()
        .filter(l -> l.getNome() != null &&
                l.getNome().toLowerCase().startsWith(nomeLower))
        .collect(Collectors.toList());

    }

}
