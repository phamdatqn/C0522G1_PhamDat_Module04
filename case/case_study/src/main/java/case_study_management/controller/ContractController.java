package case_study_management.controller;


import case_study_management.dto.ContractDetailDto;
import case_study_management.dto.ContractDto;
import case_study_management.dto.IAttachFacilityDto;
import case_study_management.dto.IContractDetailDto;
import case_study_management.model.contract.Contract;
import case_study_management.service.contract.IContractDetailService;
import case_study_management.service.contract.IContractService;
import case_study_management.service.customer.ICustomerService;
import case_study_management.service.employee.IEmployeeService;
import case_study_management.service.facility.IAttachFacilityService;
import case_study_management.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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

    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("")
    public String home(@PageableDefault(value = 3) Pageable pageable, @RequestParam(defaultValue = "") String search, Model model) {

        model.addAttribute("contractList", iContractService.findByNameCustomer(search, pageable));
        model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
        model.addAttribute("customerNameDtoList", iCustomerService.findByNameDto());
        model.addAttribute("employeeNameDtoList", iEmployeeService.findByNameDto());
        model.addAttribute("facilityNameDtoList", iFacilityService.findByNameDto());
        model.addAttribute("search", search);
        ContractDto contractDto = new ContractDto();
        model.addAttribute("contractDto", contractDto);
        model.addAttribute("contractDetailDto",new ContractDetailDto());
        return "/contract/list";
    }

    @PostMapping("/create")
    public String saveCreate(@ModelAttribute @Validated ContractDto contractDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);

        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công hợp đồng với " +
                "tên khách hàng :" + contract.getCustomer().getName());
        return "redirect:/contract";
    }

    @GetMapping("/showAttachFacilityUse/{id}")
    public String showAttachFacilityUse(@PageableDefault(value = 3) Pageable pageable, @RequestParam(defaultValue = "") String search,@PathVariable int id,Model model){

        model.addAttribute("contractList", iContractService.findByNameCustomer(search, pageable));
        model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
        model.addAttribute("customerNameDtoList", iCustomerService.findByNameDto());
        model.addAttribute("employeeNameDtoList", iEmployeeService.findByNameDto());
        model.addAttribute("facilityNameDtoList", iFacilityService.findByNameDto());
        model.addAttribute("search", search);
        ContractDto contractDto = new ContractDto();
        model.addAttribute("contractDto", contractDto);
        model.addAttribute("contractDetailDto",new ContractDetailDto());

        List<IContractDetailDto> iContractDetailDtos = iContractDetailService.findByNameAttachFacility(id);
        model.addAttribute("iContractDetailDtos",iContractDetailDtos);
        model.addAttribute("open","openModalShowDetail");
        return "contract/list";
    }
}


