package com.calt.w1crud.coffestore.Controller;

import com.calt.w1crud.coffestore.DTO.RequestProduct;
import com.calt.w1crud.coffestore.Entity.Product;
import com.calt.w1crud.coffestore.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    //return String becase the whole html site are Strings!!!
    public String getProduct(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }

    @GetMapping("/products/edit/{id}")
    //return String becase the whole html site are Strings!!!
    public String editProduct(@PathVariable("id") String id, Model model){
        model.addAttribute("aProduct",productService.getProductID(id)
        );
        return "product-form";
    }
    @GetMapping("/products/new")
    //return String becase the whole html site are Strings!!!
    public String editProduct(Model model){
        model.addAttribute("aProduct",new Product());
        return "product-form";
    }
    @PostMapping("/products/save")
    public String updateProduct(@ModelAttribute("aProduct") Product newProduct
           ){
        productService.saveProduct(newProduct);
    return "redirect:/products";
    }
    @PostMapping("/products/add")
    public ResponseEntity<Product> addProduct(@RequestBody RequestProduct productDto){

        Product newProduct = new Product(productDto.getId(),productDto.getName(),productDto.getQuantity(),productDto.getPrice());
        productService.saveProduct(newProduct);
        return ResponseEntity.status(201).body(newProduct);
    }
    @DeleteMapping("/products/delete")
    public ResponseEntity<Product> deleteProduct(@RequestBody RequestProduct productDto){
        Product tProduct = new Product(productDto.getId(),productDto.getName(),productDto.getQuantity(),productDto.getPrice());
        productService.deleteProduct(tProduct);
        return ResponseEntity.status(201).body(tProduct);
    }
}
