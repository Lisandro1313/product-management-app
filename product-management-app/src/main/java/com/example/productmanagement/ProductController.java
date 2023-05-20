package com.example.productmanagement;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProductData) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(updatedProductData.getName());
        product.setDescription(updatedProductData.getDescription());
        product.setPrice(updatedProductData.getPrice());
        product.setQuantity(updatedProductData.getQuantity());

        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam(value = "name", required = false) String name) {
        List<Product> products;
        if (name != null) {
            Product product = productRepository.findByName(name);
            if (product != null) {
                products = Collections.singletonList(product);
            } else {
                products = Collections.emptyList();
            }
        } else {
            products = productRepository.findAll();
        }
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sorted-by-price")
    public ResponseEntity<List<Product>> getAllProductsSortedByPrice() {
        List<Product> products = productRepository.findAllByOrderByPriceAsc();
        return ResponseEntity.ok(products);
    }
}
