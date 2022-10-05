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

    private void employeeList(@PageableDefault(value = 3) Pageable pageable, @RequestParam(defaultValue = "") String search, Model model) {
        model.addAttribute("employeeList", iEmployeeService.findByNameEmployee(search, pageable));
        model.addAttribute("search", search);
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
    }

    @GetMapping("")
    public String home(@PageableDefault(value = 3) Pageable pageable, @RequestParam(defaultValue = "") String search, Model model) {
//        model.addAttribute("employeeList", iEmployeeService.findByNameEmployee(search, pageable));
//        model.addAttribute("search", search);
//        model.addAttribute("divisionList",iDivisionService.findAll());
//        model.addAttribute("positionList",iPositionService.findAll());
//        model.addAttribute("educationDegreeList",iEducationDegreeService.findAll());
        employeeList(pageable, search, model);
        model.addAttribute("createEmployeeDto", new EmployeeDto());
        return "/employee/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("newEmployeeDto", new EmployeeDto());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
        return "/employee/create";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, @PageableDefault(value = 3) Pageable pageable,
                                 @RequestParam(defaultValue = "") String search, Model model, RedirectAttributes redirectAttributes) {

        Optional<Employee> employee = iEmployeeService.findById(id);
        if (!employee.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "LỖI: ID nhân viên không tồn tại!");
            return "redirect:/error";
        }

        EmployeeDto employeeDto = new EmployeeDto();

        BeanUtils.copyProperties(employee.get(), employeeDto);

        model.addAttribute("updateEmployeeDto", employeeDto);

        employeeList(pageable, search, model);
        model.addAttribute("action", "openModalUpdate");
        return "/employee/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Optional<Employee> employee = iEmployeeService.findById(id);
        if (!employee.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "LỖI: ID nhân viên không tồn tại!");
            return "redirect:/error";
        }
        iEmployeeService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Đã xóa " + employee.get().getName() + " thành công !");
        return "redirect:/employee";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute EmployeeDto employeeDto, RedirectAttributes redirectAttributes) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);

        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công: " + employee.getName());
        return "redirect:/employee";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute EmployeeDto employeeDto, RedirectAttributes redirectAttributes) {
        Optional<Employee> employee = iEmployeeService.findById(employeeDto.getId());
        if (!employee.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "LỖI: ID khách hàng không tồn tại!");
            return "redirect:/error";
        }

        BeanUtils.copyProperties(employeeDto, employee.get());

        iEmployeeService.save(employee.get());

        redirectAttributes.addFlashAttribute("message", "Đã cập nhập " + employee.get().getName() + " thành công !");
        return "redirect:/employee";
    }
}
