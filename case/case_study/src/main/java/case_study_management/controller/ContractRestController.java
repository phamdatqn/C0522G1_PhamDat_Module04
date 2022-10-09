package case_study_management.controller;

import case_study_management.dto.ContractDto;
import case_study_management.model.contract.Contract;
import case_study_management.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contract")
@CrossOrigin("*")
public class ContractRestController {

    @Autowired
    private IContractService iContractService;

    @PostMapping()
    public ResponseEntity<Contract> createContract(@RequestBody ContractDto contractDto) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        iContractService.save(contract);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteContract(@PathVariable int id) {
        Contract contract = iContractService.findById(id).orElse(null);
        if (contract == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }
}
