package case_study_management.controller;

import case_study_management.dto.FacilityDto;
import case_study_management.model.facility.Facility;
import case_study_management.service.facility.IFacilityService;
import case_study_management.service.facility.IFacilityTypeService;
import case_study_management.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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

        model.addAttribute("facilityList", iFacilityService.findByNameFacility(search, pageable));
        model.addAttribute("search", search);

        return "/facility/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("newFacilityDto", new FacilityDto());
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());

        return "/facility/create";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Facility> facility = iFacilityService.findById(id);

        if (!facility.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "LỖI: ID dịch vụ không tồn tại!");
            return "redirect:/error";
        }

        FacilityDto facilityDto = new FacilityDto();

        BeanUtils.copyProperties(facility.get(), facilityDto);

        model.addAttribute("facilityDto", facilityDto);
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        return "/facility/update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Optional<Facility> facility = iFacilityService.findById(id);

        if (!facility.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "LỖI: ID dịch vụ không tồn tại!");
            return "redirect:/error";
        }

        iFacilityService.delete(id);

        redirectAttributes.addFlashAttribute("message", "Đã xóa " + facility.get().getName() + " thành công !");
        return "redirect:/facility";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute FacilityDto facilityDto, RedirectAttributes redirectAttributes) {
        Facility facility = new Facility();

        BeanUtils.copyProperties(facilityDto, facility);

        iFacilityService.save(facility);

        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công: " + facility.getName());
        return "redirect:/facility";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute FacilityDto facilityDto, RedirectAttributes redirectAttributes) {
        Facility facility = new Facility();

        BeanUtils.copyProperties(facilityDto, facility);

        iFacilityService.save(facility);

        redirectAttributes.addFlashAttribute("message", "Cập nhập thành công: " + facility.getName());
        return "redirect:/facility";
    }
}
