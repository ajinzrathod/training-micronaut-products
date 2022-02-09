package co.incubyte;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.naming.NameAlreadyBoundException;
import java.util.Optional;

@Controller("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Post("/save")
    public Product saveProduct(@Body Product product) throws NameAlreadyBoundException {
        return productService.saveProduct(product);
    }

    @Post("/findAll")
    public Iterable<Product> getProducts() {
        return productService.getProducts() ;
    }

    @Post("/findById/{id}")
    public Optional<Product> findById(Long id) {
        return productService.findById(id);
    }

    @Get("/findByName/{name}")
    public Product findByName(String name) {
        return productService.findByName(name);
    }
}
