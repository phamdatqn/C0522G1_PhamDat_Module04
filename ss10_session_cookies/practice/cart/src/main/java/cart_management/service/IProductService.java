package cart_management.service;

import cart_management.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(String search,Pageable pageable);
    Optional<Product> findById(int id);
}
