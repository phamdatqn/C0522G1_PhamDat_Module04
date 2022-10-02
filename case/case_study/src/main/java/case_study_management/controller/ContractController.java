package case_study_management.controller;


import case_study_management.service.contract.IContractService;
import case_study_management.service.customer.ICustomerService;
import case_study_management.service.employee.IEmployeeService;
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

    @GetMapping("")
    public String home(@PageableDefault(value = 3) Pageable pageable, @RequestParam(defaultValue = "") String search, Model model) {
        model.addAttribute("contractList", iContractService.findByNameCustomer(search, pageable));
        model.addAttribute("customerList", iContractService.findByNameCustomer(search, pageable));
        model.addAttribute("employeeList", iContractService.findByNameCustomer(search, pageable));
        model.addAttribute("facilityList", iContractService.findByNameCustomer(search, pageable));
        model.addAttribute("search", search);
        return "/contract/list";
    }

}
