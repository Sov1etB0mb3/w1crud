package com.calt.w1crud.coffeestore.Config;

import com.calt.w1crud.coffeestore.Entity.Category;
import com.calt.w1crud.coffeestore.Entity.Product;
import com.calt.w1crud.coffeestore.Service.CategoryService;
import com.calt.w1crud.coffeestore.Service.ProductService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//This class used for create all tables
@Component
public class DataInitializer implements CommandLineRunner {


    private final CategoryService categoryService;
    private final ProductService productService;


    public DataInitializer(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
       Category category1 = new Category("Cafe0","Something");
       Category category2 = new Category("Cafe1","Something1");
       Category category3 = new Category("Cafe2","Something2");
        Product product1=new Product("CF0","Cafe 000",14,55);
        category1.addProduct(product1);
        Product product2=new Product("CF1","Cafe 001",17,65);
        category2.addProduct(product2);
        Product product3=new Product("CF2","Cafe 002",10,45);
        category3.addProduct(product3);
       categoryService.saveCategory(category1);
       categoryService.saveCategory(category2);
       categoryService.saveCategory(category3);

       productService.saveProduct(product1);
        productService.saveProduct(product2);
        productService.saveProduct(product3);
    }


}
