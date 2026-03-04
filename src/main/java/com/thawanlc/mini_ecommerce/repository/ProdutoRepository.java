package com.thawanlc.mini_ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thawanlc.mini_ecommerce.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    
}
