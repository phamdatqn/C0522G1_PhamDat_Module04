package case_study_management.service.customer;

import case_study_management.dto.ICustomerDto;
import case_study_management.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    ICustomerDto checkFindIdCard(String idCard);

    List<Customer> findAll();

    Optional<Customer> findById(int id);

    void save(Customer customer);

    Page<Customer> findByNameCustomer(String keySearch, Pageable pageable);

    void delete(int id);

    List<ICustomerDto> findByNameDto();
}
