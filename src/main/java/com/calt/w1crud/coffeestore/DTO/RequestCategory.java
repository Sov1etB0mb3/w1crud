package com.calt.w1crud.coffeestore.DTO;

import com.calt.w1crud.coffeestore.Entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

//@NoArgsConstructor
//@AllArgsConstructor


public class RequestCategory {

    private Long id;

    private String name;
    private String description;
    List<Product> listProduct = new ArrayList<>();
    public RequestCategory() {
    }

    public RequestCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
//    public void addProduct(Product product){
//        this.listProduct.add(product);
//        product.setCategory(this);
//    }
//    public void deleteProduct(Product product){
//        this.listProduct.remove(product);
//        product.setCategory(null);
//    }
}
