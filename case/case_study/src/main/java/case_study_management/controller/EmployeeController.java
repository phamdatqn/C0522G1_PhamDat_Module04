package case_study_management.controller;

import case_study_management.dto.EmployeeDto;
import case_study_management.model.employee.Employee;
import case_study_management.service.employee.IDivisionService;
import case_study_management.service.employee.IEducationDegreeService;
import case_study_management.service.employee.IEmployeeService;
import case_study_management.service.employee.IPositionService;
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

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    private void employeeList(@PageableDefault(value = 5) Pageable pageable, @RequestParam(defaultValue = "") String search, Model model) {
        model.addAttribute("employeeList", iEmployeeService.findByNameEmployee(search, pageable));
        model.addAttribute("search", search);
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
    }

    @GetMapping("")
    public String home(@PageableDefault(value = 5) Pageable pageable, @RequestParam(defaultValue = "") String search, Model model) {
//        model.addAttribute("employeeList", iEmployeeService.findByNameEmployee(search, pageable));
//        model.addAttribute("search", search);
//        model.addAttribute("divisionList",iDivisionService.findAll());
//        model.addAttribute("positionList",iPositionService.findAll());
//        model.addAttribute("educationDegreeList",iEducationDegreeService.findAll());
        model.addAttribute("employeeDto", new EmployeeDto());
        employeeList(pageable, search, model);
//
//        LocalDate minAge = LocalDate.now().minusYears(80);
//        LocalDate maxAge = LocalDate.now().minusYears(18);
//        model.addAttribute("minAge", minAge);
//        model.addAttribute("maxAge", maxAge);

        return "/employee/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
        return "/employee/create";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, @PageableDefault(value = 3) Pageable pageable,
                                 @RequestParam(defaultValue = "") String search, Model model, RedirectAttributes redirectAttributes) {

        Employee employee = iEmployeeService.findById(id).orElse(null);

        if (employee == null) {
            redirectAttributes.addFlashAttribute("message", "L???I: ID nh??n vi??n kh??ng t???n t???i!");
            return "redirect:/error";
        }

        EmployeeDto employeeDto = new EmployeeDto();

        BeanUtils.copyProperties(employee, employeeDto);

        employeeList(pageable, search, model);
        model.addAttribute("employeeDto", employeeDto);

        model.addAttribute("action", "openModalUpdate");

        return "/employee/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Optional<Employee> employee = iEmployeeService.findById(id);
        if (!employee.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "L???I: ID nh??n vi??n kh??ng t???n t???i!");
            return "redirect:/error";
        }
        iEmployeeService.delete(id);
        redirectAttributes.addFlashAttribute("message", "???? x??a " + employee.get().getName() + " th??nh c??ng !");
        return "redirect:/employee";
    }

    @PostMapping("/create")
    public String saveCreate(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);

        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Th??m m???i th??nh c??ng: " + employee.getName());
        return "redirect:/employee";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute EmployeeDto employeeDto, RedirectAttributes redirectAttributes) {
        Employee employee = iEmployeeService.findById(employeeDto.getId()).orElse(null);

        if (employee == null) {
            redirectAttributes.addFlashAttribute("message", "L???I: ID kh??ch h??ng kh??ng t???n t???i!");
            return "redirect:/error";
        }

        BeanUtils.copyProperties(employeeDto, employee);

        iEmployeeService.save(employee);

        redirectAttributes.addFlashAttribute("message", "???? c???p nh???p " + employee.getName() + " th??nh c??ng !");
        return "redirect:/employee";
    }
}
