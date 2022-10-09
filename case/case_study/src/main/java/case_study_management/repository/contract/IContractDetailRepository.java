package case_study_management.repository.contract;

import case_study_management.dto.IAttachFacilityDto;
import case_study_management.dto.IContractDetailDto;
import case_study_management.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value ="select contract_detail.id as idDto,`name` as nameAttachFacilityDto,cost as costDto,unit as unitDto,status as statusDto, " +
            "amount as amountDto " +
            "from contract_detail " +
            "left join  attach_facility on contract_detail.attach_facility_id = attach_facility.id " +
            "left join contract on contract_detail.contract_id = contract.id " +
            "where contract_detail.is_delete=0 and contract.is_delete=0 " +
            "and contract_id = :idContract",nativeQuery = true)
    List<IContractDetailDto> findByNameAttachFacility(@Param("idContract")int id);
}
