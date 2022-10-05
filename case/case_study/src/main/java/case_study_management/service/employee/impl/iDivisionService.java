package case_study_management.service.employee.impl;

import case_study_management.model.employee.Divisions;
import case_study_management.repository.employee.IDivisionRepository;
import case_study_management.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class iDivisionService implements IDivisionService {

    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Divisions> findAll() {
        return iDivisionRepository.findAll();
    }
}
