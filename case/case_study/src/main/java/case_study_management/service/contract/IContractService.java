package case_study_management.service.contract;

import case_study_management.model.contract.Contract;
import case_study_management.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IContractService {
    Optional<Contract> findById(int id);

    void save(Contract contract);

    Page<Contract> findByNameCustomer(String keySearch, Pageable pageable);

    void delete(int id);
}
