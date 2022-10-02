package case_study_management.repository.employee;

import case_study_management.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from employee where name like %:keySearch% and is_delete = false", nativeQuery = true)
    Page<Employee> findByNameEmployee(@Param("keySearch") String keySearch, Pageable pageable);
}
