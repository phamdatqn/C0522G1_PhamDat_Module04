package case_study_management.controller;

import case_study_management.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("")
    public String home(@PageableDefault(value = 3)Pageable pageable, @RequestParam(defaultValue = "") String search, Model model){
        model.addAttribute("employeeList",iEmployeeService.findAll(pageable));
        model.addAttribute("search",search);
        return "/employee/list";
    }
}
