package customer_management.service;

import customer_management.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    Optional<Customer> findById(int id);

    void save(Customer customer);

    void delete(int id);
}
