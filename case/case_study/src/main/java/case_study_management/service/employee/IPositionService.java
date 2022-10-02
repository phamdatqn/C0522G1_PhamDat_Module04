package case_study_management.service.employee;

import case_study_management.model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
}
