package case_study_management.service.customer;

import case_study_management.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    Optional<Customer> findById(int id);

    void save(Customer customer);

    Page<Customer> findByName(String keySearch, Pageable pageable);

    Page<Customer> findByCustomer(int chooseSelect, Pageable pageable);

    void delete(int id);
}
