package co.incubyte;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.repository.PageableRepository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>, PageableRepository<Product, Long> {
    Product findByName(String name);
    boolean existsByName(String name);
    List<Product> findAllByRate(double price, Pageable pageable);
}
