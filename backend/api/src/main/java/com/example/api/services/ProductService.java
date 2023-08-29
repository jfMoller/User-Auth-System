package com.example.api.services;

import com.example.api.entities.Product;
import com.example.api.exceptions.UnauthorizedException;
import com.example.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void createNewProduct(Product product) {
        Product newProduct = new Product(product.getName());
        productRepository.save(newProduct);
    }

    public void editProduct(Product updatedProduct) {
        Optional<Product> selectedProduct = productRepository.findById(updatedProduct.getId());
        if (selectedProduct.isPresent()) {
            productRepository.save(new Product(updatedProduct.getId(), updatedProduct.getName()));
        } else {
            throw new UnauthorizedException("Invalid product ID; product does not exist");
        }
    }

    public void deleteProduct(Long productID) {
        productRepository.deleteById(productID);
    }

}