package case_study_management.service.employee.impl;

import case_study_management.model.employee.Position;
import case_study_management.repository.employee.IPositionRepository;
import case_study_management.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
