package com.calt.w1crud.coffeestore.Controller;

import com.calt.w1crud.coffeestore.DTO.RequestProduct;
import com.calt.w1crud.coffeestore.Entity.Product;
import com.calt.w1crud.coffeestore.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    //return String becase the whole html site are Strings!!!
    public ResponseEntity<List<Product>> getProduct(){
        List<Product> productList= productService.getAllProducts();

        if(productList.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(productList);
    }
    @GetMapping("/{id}")
    //return String becase the whole html site are Strings!!!
    public ResponseEntity<Product> getProduct(@PathVariable("id") String id){
        Product rProduct= productService.getProductID(id);

        if(isNull( productService.getProductID(id))){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(rProduct);
    }

    @PutMapping("/{id}")
    //return String becase the whole html site are Strings!!!
    public String editProduct(@PathVariable("id") String id, Model model){
        model.addAttribute("aProduct",productService.getProductID(id));

        return "product-form";
    }

    @PostMapping("")
    public ResponseEntity<Product> addProduct(@RequestBody RequestProduct productDto){

        Product newProduct = new Product(productDto.getId(),productDto.getName(),productDto.getQuantity(),productDto.getPrice());
        productService.saveProduct(newProduct);
        return ResponseEntity.status(201).body(newProduct);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Product> deleteProduct(@RequestBody RequestProduct productDto){
        Product tProduct = new Product(productDto.getId(),productDto.getName(),productDto.getQuantity(),productDto.getPrice());
        productService.deleteProduct(tProduct);
        return ResponseEntity.status(201).body(tProduct);
    }
}
