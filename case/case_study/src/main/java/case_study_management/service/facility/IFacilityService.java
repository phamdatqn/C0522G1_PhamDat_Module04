package case_study_management.service.facility;

import case_study_management.dto.IFacilityDto;
import case_study_management.model.customer.Customer;
import case_study_management.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();

    Page<Facility> findByNameFacility(String keySearch, Pageable pageable);

    List<IFacilityDto> findByNameDto();
}
