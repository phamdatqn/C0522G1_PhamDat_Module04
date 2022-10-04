package case_study_management.service.customer.impl;

import case_study_management.dto.ICustomerDto;
import case_study_management.model.customer.Customer;
import case_study_management.repository.customer.ICustomerRepository;
import case_study_management.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
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
    public Page<Customer> findByNameCustomer(String keySearch, Pageable pageable) {
        return iCustomerRepository.findByNameCustomer(keySearch,pageable);
    }


    @Override
    public void delete(int id) {
        iCustomerRepository.deleteById(id);

    }

    @Override
    public List<ICustomerDto> findByNameDto() {
        return iCustomerRepository.findByNameDto();
    }
}
