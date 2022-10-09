package case_study_management.service.contract.impl;

import case_study_management.dto.IAttachFacilityDto;
import case_study_management.dto.IContractDetailDto;
import case_study_management.model.contract.ContractDetail;
import case_study_management.repository.contract.IContractDetailRepository;
import case_study_management.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository iContractDetailRepository;


    @Override
    public List<IContractDetailDto> findByNameAttachFacility(int id) {
        return iContractDetailRepository.findByNameAttachFacility(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }
}
