package case_study_management.service.facility;

import case_study_management.dto.FacilityDto;
import case_study_management.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);
    List<FacilityDto> findAll();
}
