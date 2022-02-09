package co.incubyte;

import io.micronaut.data.exceptions.EmptyResultException;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@Singleton
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product saveProduct(@Valid Product product) {
//        validateUniqueProduct(product);
        return productRepository.save(product);
    }

    @Transactional
    public String validateUniqueProduct(String product) {
        Product existingProduct = productRepository.findByName(product);
        if (existingProduct != null) {
            return "Existing";
        }
        return "not Existing";
    }

    @Transactional
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}
