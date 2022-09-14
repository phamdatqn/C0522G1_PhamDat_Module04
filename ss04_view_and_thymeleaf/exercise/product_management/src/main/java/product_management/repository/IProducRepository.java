package product_management.repository;

import product_management.model.Product;

import java.util.List;

public interface IProducRepository {
    List<Product> displayAll();

    void save(Product product);

    Product findById(int id);

    List<Product> searchByName(String name);

    void update(Product product);

    void delete(int id);
}
