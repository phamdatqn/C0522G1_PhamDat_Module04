package case_study_management.repository.contract;

import case_study_management.model.contract.Contract;
import case_study_management.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select * from contract where customer_id like %:keySearch% and is_delete = false", nativeQuery = true)
    Page<Contract> findByNameCustomer(@Param("keySearch") String keySearch, Pageable pageable);
}
