package case_study_management.service.facility.impl;

import case_study_management.dto.IFacilityDto;
import case_study_management.model.facility.Facility;
import case_study_management.repository.facility.IFacilityRepository;
import case_study_management.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public Page<Facility> findByNameFacility(String keySearch, Pageable pageable) {
        return iFacilityRepository.findByNameFacility(keySearch, pageable);
    }

    @Override
    public List<IFacilityDto> findByNameDto() {
        return iFacilityRepository.findByNameDto();
    }

    @Override
    public Optional<Facility> findById(int id) {
        return iFacilityRepository.findById(id);
    }
}
