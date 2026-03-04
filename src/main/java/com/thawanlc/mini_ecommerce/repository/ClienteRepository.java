package com.thawanlc.mini_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thawanlc.mini_ecommerce.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
