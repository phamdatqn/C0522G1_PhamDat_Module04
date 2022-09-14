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
    public String home(Model model) {
        List<Product> productList = iProducService.displayAll();
        model.addAttribute("productList", productList);
        return "home";
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

    @GetMapping("/search/")
    public String search(@RequestParam String search, Model model, RedirectAttributes redirectAttributes) {
        List<Product> productList;
        if (StringUtils.hasText(search)) {
            productList = iProducService.searchByName(search);

        } else {
            productList = iProducService.displayAll();
        }
        redirectAttributes.addFlashAttribute("message", "Bạn đang tìm thông tin liên quan đến " + search);
        model.addAttribute("productList", productList);
        return "home";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        iProducService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Cập nhập thành công " + product.getName());
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        iProducService.delete(product.getId());
        redirectAttributes.addFlashAttribute("message", "Xóa thành công " + product.getName());
        return "redirect:/product";
    }
}
