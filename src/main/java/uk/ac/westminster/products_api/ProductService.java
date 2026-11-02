package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // Store all products in a list
    private List<Product> products = new ArrayList<>();

    // Automatically assign the next ID
    private Long nextId = 1L;

    public ProductService() {
        products.add(new DigitalProduct(nextId ++, "Clean Code (E-book)", 29.99,"/downloads/clean-code.pdf", 4.2));
        products.add(new PhysicalProduct(nextId ++, "27-inch Monito", 24999, 5.4, "61cm x 41cm x 18cm"));
    }

    // Get all products
    public List<Product> getAllProducts() {
        return products;
    }

    // Add a product
    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    // Find a product by ID
    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // Delete a product by ID
    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    // Search products by name
    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

}