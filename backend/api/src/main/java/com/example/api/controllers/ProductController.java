package com.example.api.controllers;

import com.example.api.entities.Product;
import com.example.api.entities.UnauthorizedException;
import com.example.api.services.ProductService;
import com.example.api.token.JwtTokenService;
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

        JwtTokenService tokenService = new JwtTokenService();
        boolean isValidToken = tokenService.validateToken(token);

        if (isValidToken) {
            return productService.getProducts();
        } else {
            return null;
        }
    }

    @PutMapping("/products")
    public void editProduct(@RequestHeader("Token") String token, @RequestBody Product product) {

        JwtTokenService tokenService = new JwtTokenService();
        boolean isValidToken = tokenService.validateToken(token);

        if (isValidToken) {
            productService.editProduct(product);
        } else {
            throw new UnauthorizedException("Invalid token.");
        }
    }

    @DeleteMapping("/products/{productID}")
    public void deleteProduct(@RequestHeader("Token") String token, @PathVariable Long productID) {

        JwtTokenService tokenService = new JwtTokenService();
        boolean isValidToken = tokenService.validateToken(token);

        if (isValidToken) {
            productService.deleteProduct(productID);
        } else {
            throw new UnauthorizedException("Invalid token.");
        }
    }
}