package case_study_management.service.facility.impl;

import case_study_management.dto.IAttachFacilityDto;
import case_study_management.dto.IContractDto;
import case_study_management.model.facility.AttachFacility;
import case_study_management.repository.facility.IAttachFacilityRepository;
import case_study_management.service.facility.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll();
    }

}
