package product_management.service;

import product_management.model.Product;

import java.util.List;

public interface IProducService {
    List<Product> displayAll();

    Product findById(int id);

    void update(int id, Product product);

    void delete(int id);

    List<Product> searchByName(String name);
}
