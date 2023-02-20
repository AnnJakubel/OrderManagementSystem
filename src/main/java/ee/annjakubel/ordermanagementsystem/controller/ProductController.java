package ee.annjakubel.ordermanagementsystem.controller;

import ee.annjakubel.ordermanagementsystem.model.Product;
import ee.annjakubel.ordermanagementsystem.repository.ProductRepository;
import ee.annjakubel.ordermanagementsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//https://localhost:8080
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @PostMapping("order-management/product")
    public ResponseEntity<List<Product>> addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.ok().body(productRepository.findAll());
    }

    @GetMapping("order-management/product")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(productRepository.findAll());
    }
}
