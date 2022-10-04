package case_study_management.controller;


import case_study_management.dto.ContractDto;
import case_study_management.dto.CustomerDto;
import case_study_management.service.contract.IContractService;
import case_study_management.service.customer.ICustomerService;
import case_study_management.service.employee.IEmployeeService;
import case_study_management.service.facility.IAttachFacilityService;
import case_study_management.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @GetMapping("")
    public String home(@PageableDefault(value = 3) Pageable pageable, @RequestParam(defaultValue = "") String search, Model model) {

        model.addAttribute("contractList", iContractService.findByNameCustomer(search, pageable));
        model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
        model.addAttribute("customerNameDtoList", iCustomerService.findByNameDto());
        model.addAttribute("employeeNameDtoList", iEmployeeService.findByNameDto());
        model.addAttribute("facilityNameDtoList", iFacilityService.findByNameDto());
        model.addAttribute("search", search);
        return "/contract/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("newContractDto", new ContractDto());
        model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
        model.addAttribute("customerNameDtoList", iCustomerService.findByNameDto());
        model.addAttribute("employeeNameDtoList", iEmployeeService.findByNameDto());
        model.addAttribute("facilityNameDtoList", iFacilityService.findByNameDto());
        return "/contract/create";
    }

}
