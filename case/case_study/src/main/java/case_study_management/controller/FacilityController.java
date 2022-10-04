package case_study_management.controller;

import case_study_management.dto.ContractDto;
import case_study_management.dto.CustomerDto;
import case_study_management.dto.FacilityDto;
import case_study_management.model.customer.Customer;
import case_study_management.model.customer.CustomerType;
import case_study_management.model.facility.Facility;
import case_study_management.model.facility.FacilityType;
import case_study_management.service.facility.IFacilityService;
import case_study_management.service.facility.IFacilityTypeService;
import case_study_management.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("")
    public String home(@PageableDefault(value = 4) Pageable pageable, Model model,
                       @RequestParam(defaultValue = "") String search) {
        model.addAttribute("facilityList", iFacilityService.findByNameFacility(search,pageable));
        model.addAttribute("search", search);
        return "/facility/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("newFacilityDto", new FacilityDto());
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        return "/facility/create";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model) {
        Facility facility = iFacilityService.findById(id).get();

        FacilityDto facilityDto = new FacilityDto();

        FacilityType facilityType = facility.getFacilityType();
        facilityDto.setFacilityType(facilityDto.getId());

        BeanUtils.copyProperties(facility, facilityDto);

        model.addAttribute("facilityDto", facilityDto);
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        return "/facility/update";
    }



}
