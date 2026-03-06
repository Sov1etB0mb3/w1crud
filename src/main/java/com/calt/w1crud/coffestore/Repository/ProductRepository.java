package com.calt.w1crud.coffestore.Repository;


import com.calt.w1crud.coffestore.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product> findProductByName(String name);
    
}
