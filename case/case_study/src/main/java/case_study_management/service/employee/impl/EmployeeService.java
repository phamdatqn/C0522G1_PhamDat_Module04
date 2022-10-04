package case_study_management.service.employee.impl;

import case_study_management.dto.IEmployeeDto;
import case_study_management.model.employee.Employee;
import case_study_management.repository.employee.IEmployeeRepository;
import case_study_management.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;


    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findByNameEmployee(String keySearch, Pageable pageable) {
        return iEmployeeRepository.findByNameEmployee(keySearch, pageable);
    }

    @Override
    public void delete(int id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public List<IEmployeeDto> findByNameDto() {
        return iEmployeeRepository.findByNameDto();
    }


}
