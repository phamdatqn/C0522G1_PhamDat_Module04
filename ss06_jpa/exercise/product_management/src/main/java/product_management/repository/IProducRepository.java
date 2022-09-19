package product_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import product_management.model.Product;

import java.util.List;

public interface IProducRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from Product where name like %:keySearch%", nativeQuery = true)
    List<Product> findByName(@Param("keySearch") String keySearch);
}
