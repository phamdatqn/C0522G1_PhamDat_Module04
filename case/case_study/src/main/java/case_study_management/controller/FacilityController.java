package case_study_management.controller;

import case_study_management.model.facility.Facility;
import case_study_management.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping("")
    public String home(@PageableDefault(value = 4)Pageable pageable, Model model,
                       @RequestParam(defaultValue = "")String search){
        model.addAttribute("facilityList",iFacilityService.findAll(pageable));
        model.addAttribute("search",search);
        return "facility/list";
    }
}
