package case_study_management.service.customer.impl;

import case_study_management.model.customer.Customer;
import case_study_management.repository.customer.ICustomerRepository;
import case_study_management.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> findByName(String keySearch, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Customer> findByCustomer(int chooseSelect, Pageable pageable) {
        return null;
    }

    @Override
    public void delete(int id) {
        iCustomerRepository.deleteById(id);

    }
}
