package case_study_management.repository.employee;

import case_study_management.model.employee.Divisions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Divisions,Integer> {
}
