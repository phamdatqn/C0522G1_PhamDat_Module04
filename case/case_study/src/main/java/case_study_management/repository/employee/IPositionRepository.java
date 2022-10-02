package case_study_management.repository.employee;

import case_study_management.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Integer> {
}
