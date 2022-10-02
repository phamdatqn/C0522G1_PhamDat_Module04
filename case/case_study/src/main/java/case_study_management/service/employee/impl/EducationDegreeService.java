package case_study_management.service.employee.impl;

import case_study_management.model.employee.EducationDegree;
import case_study_management.repository.employee.IEducationDegreeRepository;
import case_study_management.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
