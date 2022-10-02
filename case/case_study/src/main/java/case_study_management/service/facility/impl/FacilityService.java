package case_study_management.service.facility.impl;

import case_study_management.dto.FacilityDto;
import case_study_management.model.facility.Facility;
import case_study_management.repository.facility.IFacilityRepository;
import case_study_management.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return iFacilityRepository.findAll(pageable);
    }

    @Override
    public List<FacilityDto> findAll() {
        return iFacilityRepository.findA();
    }
}
