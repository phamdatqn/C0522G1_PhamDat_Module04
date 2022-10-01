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

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public String home(@PageableDefault(value = 3)Pageable pageable,
                       @RequestParam(defaultValue = "") String search, Model model){
        model.addAttribute("customerList",iCustomerService.findAll(pageable));
        model.addAttribute("search",search);
        return "customer/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("newCustomerDto",new CustomerDto());
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        return "/customer/create";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model){
        model.addAttribute("customer",iCustomerService.findById(id));
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        return "/customer/update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id,RedirectAttributes redirectAttributes){
        Customer customer = iCustomerService.findById(id).get();
        if (customer==null){
            redirectAttributes.addFlashAttribute("message","LỖI: ID khách hàng không tồn tại!");
            return "error";
        }
        iCustomerService.delete(id);
        redirectAttributes.addFlashAttribute("message","Đã xóa "+ customer.getName()+ " thành công !");
        return "redirect:/customer";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute CustomerDto customerDto, RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        CustomerType customerType = new CustomerType();
        customerType.setId(customerDto.getCustomerType());
        BeanUtils.copyProperties(customerDto,customer);
        customer.setCustomerType(customerType);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công: " + customerDto.getName());
        return "redirect:/customer";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Cập nhập thành công: " + customer.getName());
        return "redirect:/customer";
    }
}
