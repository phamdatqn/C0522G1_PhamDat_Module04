package case_study_management.repository.facility;

import case_study_management.dto.IFacilityDto;
import case_study_management.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from facility where name like %:keySearch% and is_delete = false", nativeQuery = true)
    Page<Facility> findByNameFacility(@Param("keySearch") String keySearch, Pageable pageable);

    @Query(value = "select id as idDto,name as nameDto from facility", nativeQuery = true)
    List<IFacilityDto> findByNameDto();
}
