package case_study_management.service.contract;

import case_study_management.dto.IContractDetailDto;
import case_study_management.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<IContractDetailDto> findByNameAttachFacility(int id);

    void save(ContractDetail contractDetail);
}
