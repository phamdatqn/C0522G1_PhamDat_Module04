package product_management.service;

import product_management.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProducService {
    List<Product> findAll();

    Optional<Product> findById(int id);

    void update(Product product);

    void create(Product product);

    void delete(Product product);

    List<Product> findByName(String keySearch);

}
