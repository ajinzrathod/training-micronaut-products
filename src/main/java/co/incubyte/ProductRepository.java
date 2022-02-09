package co.incubyte;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>, PageableRepository<Product, Long> {
    Product findByName(String name);
    boolean existsByName(String name);
}
