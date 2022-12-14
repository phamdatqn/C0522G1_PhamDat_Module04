package case_study_management.controller;

import case_study_management.dto.CustomerDto;
import case_study_management.dto.ICustomerDto;
import case_study_management.model.customer.Customer;
import case_study_management.service.customer.ICustomerService;
import case_study_management.service.customer.ICustomerTypeService;
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

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public String home(@PageableDefault(value = 5) Pageable pageable,
                       Model model, @RequestParam(defaultValue = "") String search) {

        model.addAttribute("customerList", iCustomerService.findByNameCustomer(search, pageable));
        model.addAttribute("search", search);

        return "customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        LocalDate minAge = LocalDate.now().minusYears(80);
        LocalDate maxAge = LocalDate.now().minusYears(18);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);
        return "/customer/create";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Customer findCustomer = iCustomerService.findById(id).orElse(null);

        if (findCustomer == null) {
            redirectAttributes.addFlashAttribute("message", "L???I:Kh??ch h??ng kh??ng t???n t???i!");
            return "redirect:/error";
        }
        CustomerDto customerDto = new CustomerDto();

        BeanUtils.copyProperties(findCustomer, customerDto);

        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

        return "/customer/update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Optional<Customer> customer = iCustomerService.findById(id);

        if (!customer.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "L???I: ID kh??ch h??ng kh??ng t???n t???i!");
            return "redirect:/error";
        }

        iCustomerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "???? x??a " +
                customer.get().getName() + " th??nh c??ng !");
        return "redirect:/customer";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        ICustomerDto findICustomerDto = iCustomerService.checkFindIdCard(customerDto.getIdCard());
        boolean isDuplicateIdCard = findICustomerDto != null;
        if (bindingResult.hasFieldErrors() || isDuplicateIdCard) {
            if (isDuplicateIdCard) {
                model.addAttribute("duplicateIdCard", "S??? CMND/CCCD ???? t???n t???i, " +
                        "vui l??ng ki???m tra l???i.");
            }
            LocalDate minAge = LocalDate.now().minusYears(80);
            LocalDate maxAge = LocalDate.now().minusYears(18);
            model.addAttribute("minAge", minAge);
            model.addAttribute("maxAge", maxAge);
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
            return "/customer/create";

        } else {
            Customer customer = new Customer();

            BeanUtils.copyProperties(customerDto, customer);

            iCustomerService.save(customer);

            redirectAttributes.addFlashAttribute("message", "Th??m m???i th??nh c??ng: " +
                    customerDto.getName());
            return "redirect:/customer";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        Customer findCustomer = iCustomerService.findById(customerDto.getId()).orElse(null);

        if (findCustomer == null) {
            redirectAttributes.addFlashAttribute("message", "L???I: kh??ch h??ng kh??ng t???n t???i!");
            return "redirect:/error";
        }

        ICustomerDto findICustomerDto = iCustomerService.checkFindIdCard(customerDto.getIdCard());

        boolean isDuplicateIdCard = false;
        if (findICustomerDto != null) {
            if (findICustomerDto.getIdDto() != (customerDto.getId())) {
                isDuplicateIdCard = true;
            }
        }

        if (bindingResult.hasFieldErrors() || isDuplicateIdCard) {
            if (isDuplicateIdCard) {
                model.addAttribute("duplicateIdCard", "S??? CMND/CCCD ???? t???n t???i, " +
                        "vui l??ng ki???m tra l???i.");
            }
            LocalDate minAge = LocalDate.now().minusYears(80);
            LocalDate maxAge = LocalDate.now().minusYears(18);
            model.addAttribute("minAge", minAge);
            model.addAttribute("maxAge", maxAge);
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
            return "/customer/update";

        } else {
            BeanUtils.copyProperties(customerDto, findCustomer);

            iCustomerService.save(findCustomer);

            redirectAttributes.addFlashAttribute("message", "C???p nh???t th??nh c??ng: " +
                    customerDto.getName());
            return "redirect:/customer";
        }
    }
}
