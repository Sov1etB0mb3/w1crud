package com.calt.w1crud.coffeestore.Controller;

import com.calt.w1crud.coffeestore.DTO.RequestProduct;
import com.calt.w1crud.coffeestore.Entity.Product;
import com.calt.w1crud.coffeestore.Service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
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

        Product rProduct= productService.getProductByID(id);

        if(isNull( productService.getProductByID(id))){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(rProduct);
    }

    @PutMapping("/{id}")
    //return String becase the whole html site are Strings!!!
    public String editProduct(@PathVariable("id") String id, Model model){
        model.addAttribute("aProduct",productService.getProductByID(id));

        return "product-form";
    }

    @PostMapping("")

    public ResponseEntity<String> addProduct(@RequestBody RequestProduct productDto){
            if(productService.saveProductfromDTO(productDto)){
                return ResponseEntity.status(201).body("Created!");
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error ID! "+productDto.getId()+" already existed!");


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") String id){
        productService.deleteProduct(productService.getProductByID(id));
        return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
    }
}
