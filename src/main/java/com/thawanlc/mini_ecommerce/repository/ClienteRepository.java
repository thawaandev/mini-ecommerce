package com.thawanlc.mini_ecommerce.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thawanlc.mini_ecommerce.entity.Cliente;
import com.thawanlc.mini_ecommerce.entity.Pedido;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Pedido> findByNome(String nome);
    
}
