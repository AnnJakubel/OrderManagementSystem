package ee.annjakubel.ordermanagementsystem.controller;

import ee.annjakubel.ordermanagementsystem.model.Product;
import ee.annjakubel.ordermanagementsystem.repository.ProductRepository;
import ee.annjakubel.ordermanagementsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @PostMapping("order-management/product")
    public ResponseEntity<List<Product>> addProdcut(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.ok().body(productRepository.findAll());
    }
}
