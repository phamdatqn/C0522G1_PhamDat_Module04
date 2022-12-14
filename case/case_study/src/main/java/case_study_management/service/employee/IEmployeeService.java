package case_study_management.service.employee;

import case_study_management.dto.EmployeeDto;
import case_study_management.dto.ICustomerDto;
import case_study_management.dto.IEmployeeDto;
import case_study_management.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> findAll();

    Optional<Employee> findById(int id);

    void save(Employee employee);

    Page<Employee> findByNameEmployee(String keySearch, Pageable pageable);

    void delete(int id);

    List<IEmployeeDto> findByNameDto();
}
