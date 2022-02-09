package co.incubyte;

import io.micronaut.data.model.Pageable;
import jakarta.inject.Singleton;

import javax.naming.NameAlreadyBoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static io.micronaut.data.model.Pageable.from;

@Singleton
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product saveProduct(Product product) throws NameAlreadyBoundException {
        if(productRepository.existsByName(product.getName())) {
            throw new NameAlreadyBoundException();
        }
        return productRepository.save(product);
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

    public List<Product> getPagableByRate(int rate, int size) {
        return productRepository.findAll(Pageable.from(rate, size)).getContent();
    }
}
