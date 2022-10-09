package case_study_management.repository.facility;

import case_study_management.dto.IAttachFacilityDto;
import case_study_management.model.facility.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
}
