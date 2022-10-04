package case_study_management.service.facility;

import case_study_management.model.facility.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
}
