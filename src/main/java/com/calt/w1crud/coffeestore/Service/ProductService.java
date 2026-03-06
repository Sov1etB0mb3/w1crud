package com.calt.w1crud.coffeestore.Service;

import com.calt.w1crud.coffeestore.DTO.RequestProduct;
import com.calt.w1crud.coffeestore.Entity.Product;
import com.calt.w1crud.coffeestore.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public boolean saveProductfromDTO(RequestProduct rProduct) {
        if (!productRepository.existsById(rProduct.getId())){
            //use mapper later!
            Product newProduct = new Product(rProduct.getId(), rProduct.getName(), rProduct.getQuantity(), rProduct.getPrice());
            productRepository.save(newProduct);
            return true;
        }
        else
        return false;
    }
    public void saveProduct(Product rProduct) {
            productRepository.save(rProduct);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductByID(String id){
        return productRepository.findById(id).get();
        //productRepository.findById(id) will return an Optional<Type>
    }
    public void deleteProduct(Product product){
        productRepository.delete(product);
    }

}
