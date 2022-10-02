package case_study_management.repository.customer;

import case_study_management.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

//    @Query(value = "select * from customer where customer_name like %:nameSearch% and " +
//            "customer_address like %:addressSearch% and customer_phone like %:phoneSearch% and delete_status = false",
//            nativeQuery = true)

    @Query(value = "select * from customer where name like %:keySearch% and is_delete = false", nativeQuery = true)
    Page<Customer> findByNameCustomer(@Param("keySearch") String keySearch, Pageable pageable);

}
