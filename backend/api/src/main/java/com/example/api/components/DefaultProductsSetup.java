package com.example.api.components;

import com.example.api.entities.Product;
import com.example.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DefaultProductsSetup implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Autowired
    public DefaultProductsSetup(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //populates the products table with default products if empty on startup
    @Override
    public void run(String... args) {
        if (productRepository.count() == 0) {
            createDefaultProduct(new Product("iPhone 13"));
            createDefaultProduct(new Product("Samsung Galaxy S21"));
            createDefaultProduct(new Product("Sony PlayStation 5"));
            createDefaultProduct(new Product("Nintendo Switch"));
            createDefaultProduct(new Product("Canon EOS 5D Mark IV"));
            createDefaultProduct(new Product("Dyson V11 Vacuum Cleaner"));
            createDefaultProduct(new Product("Fitbit Charge 5"));
            createDefaultProduct(new Product("Amazon Echo Dot (4th Gen)"));
            createDefaultProduct(new Product("Microsoft Surface Laptop 4"));
            createDefaultProduct(new Product("Bose Headphones"));
        }
    }

    private void createDefaultProduct(Product user) {
        productRepository.save(user);
    }
}