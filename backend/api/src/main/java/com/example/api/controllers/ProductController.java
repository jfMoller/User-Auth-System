package com.example.api.controllers;

import com.example.api.entities.Product;
import com.example.api.util.JwtTokenUtil;
import com.example.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(@RequestHeader("Token") String token) {
        return JwtTokenUtil.handleReturnMethodAccess(token, () -> productService.getProducts());
    }

    @PutMapping("/products")
    public void editProduct(@RequestHeader("Token") String token, @RequestBody Product product) {
        JwtTokenUtil.handleVoidMethodAccess(token, () -> productService.editProduct(product));
    }

    @DeleteMapping("/products/{productID}")
    public void deleteProduct(@RequestHeader("Token") String token, @PathVariable Long productID) {
        JwtTokenUtil.handleVoidMethodAccess(token, () -> productService.deleteProduct(productID));
    }
}