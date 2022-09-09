package customer_management.repository;

import customer_management.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> displayAll();
}
