package case_study_management.controller;

import case_study_management.dto.CustomerDto;
import case_study_management.model.customer.Customer;
import case_study_management.model.customer.CustomerType;
import case_study_management.service.customer.ICustomerService;
import case_study_management.service.customer.ICustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public String home(@PageableDefault(value = 3) Pageable pageable,
                       Model model, @RequestParam(defaultValue = "") String search) {

        model.addAttribute("customerList", iCustomerService.findByNameCustomer(search, pageable));
        model.addAttribute("search", search);

        return "customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("newCustomerDto", new CustomerDto());
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

        return "/customer/create";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Customer> customer = iCustomerService.findById(id);

        if (!customer.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "LỖI: ID nhân viên không tồn tại!");
            return "redirect:/error";
        }

        CustomerDto customerDto = new CustomerDto();

        BeanUtils.copyProperties(customer.get(), customerDto);

        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

        return "/customer/update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Optional<Customer> customer = iCustomerService.findById(id);

        if (!customer.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "LỖI: ID khách hàng không tồn tại!");
            return "redirect:/error";
        }

        iCustomerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Đã xóa " + customer.get().getName() + " thành công !");
        return "redirect:/customer";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute CustomerDto customerDto, RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();

        BeanUtils.copyProperties(customerDto, customer);

        iCustomerService.save(customer);

        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công: " + customerDto.getName());
        return "redirect:/customer";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute CustomerDto customerDto, RedirectAttributes redirectAttributes) {
        Optional<Customer> customer = iCustomerService.findById(customerDto.getId());

        if (!customer.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "LỖI: ID khách hàng không tồn tại!");
            return "redirect:/error";
        }

        BeanUtils.copyProperties(customerDto, customer.get());

        CustomerType customerType = new CustomerType();

        customer.get().setCustomerType(customerType);

        iCustomerService.save(customer.get());

        redirectAttributes.addFlashAttribute("message", "Đã cập nhập " + customer.get().getName() + " thành công !");
        return "redirect:/customer";
    }
}
