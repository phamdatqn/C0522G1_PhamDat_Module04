package case_study_management.service.facility.impl;

import case_study_management.model.facility.RentType;
import case_study_management.repository.facility.IRentTypeRepository;
import case_study_management.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
