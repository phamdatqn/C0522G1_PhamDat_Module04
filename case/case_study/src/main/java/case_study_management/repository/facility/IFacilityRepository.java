package case_study_management.repository.facility;

import case_study_management.model.customer.Customer;
import case_study_management.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from contract where customer_id like %:keySearch% and is_delete = false", nativeQuery = true)
    Page<Customer> findByNameCustomer(@Param("keySearch") String keySearch, Pageable pageable);
}
