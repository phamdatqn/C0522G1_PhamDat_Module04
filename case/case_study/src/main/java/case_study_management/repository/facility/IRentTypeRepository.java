package case_study_management.repository.facility;

import case_study_management.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
