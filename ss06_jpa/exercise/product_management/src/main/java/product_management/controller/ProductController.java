package product_management.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_management.model.Product;
import product_management.service.IProducService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProducService iProducService;

    @GetMapping("")
    public String search(Model model, @RequestParam(defaultValue = "") String search) {
        List<Product> productList;
        if (StringUtils.hasText(search)) {
            productList = iProducService.findByName(search);
            model.addAttribute("message", "Bạn đang tìm thông tin liên quan đến: " + search);
            model.addAttribute("productList", productList);
        } else {
            productList = iProducService.findAll();
            model.addAttribute("productList", productList);
        }
        return "home";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model) {
        model.addAttribute("product", iProducService.findById(id));
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProducService.findById(id));
        return "delete";
    }

    @GetMapping("/view/{id}")
    public String showFormInfo(@PathVariable int id, Model model) {
        model.addAttribute("product", iProducService.findById(id));
        return "view";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        iProducService.create(product);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công: " + product.getName());
        return "redirect:/product";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        iProducService.update(product);
        redirectAttributes.addFlashAttribute("message", "Cập nhập thành công: " + product.getName());
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        iProducService.delete(product);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công: " + product.getName());
        return "redirect:/product";
    }
}
