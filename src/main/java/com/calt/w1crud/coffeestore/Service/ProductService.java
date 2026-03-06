package com.calt.w1crud.coffeestore.Service;

import com.calt.w1crud.coffeestore.Entity.Product;
import com.calt.w1crud.coffeestore.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public void saveProduct(Product product){
        productRepository.save(product);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductID(String id){
        return productRepository.findById(id).get();
        //productRepository.findById(id) will return an Optional<Type>
    }
    public void deleteProduct(Product product){
        productRepository.delete(product);
    }

}
