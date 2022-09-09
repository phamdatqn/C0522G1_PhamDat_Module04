package customer_management.service.impl;

import customer_management.model.Customer;
import customer_management.repository.ICustomerRepository;
import customer_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> displayAll() {
        return iCustomerRepository.displayAll() ;
    }
}
