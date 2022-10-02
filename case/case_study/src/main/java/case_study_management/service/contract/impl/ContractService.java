package case_study_management.service.contract.impl;

import case_study_management.model.contract.Contract;
import case_study_management.repository.contract.IContractRepository;
import case_study_management.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Optional<Contract> findById(int id) {
        return iContractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public Page<Contract> findByNameCustomer(String keySearch, Pageable pageable) {
        return iContractRepository.findByNameCustomer(keySearch, pageable);
    }

    @Override
    public void delete(int id) {
        iContractRepository.deleteById(id);
    }
}
