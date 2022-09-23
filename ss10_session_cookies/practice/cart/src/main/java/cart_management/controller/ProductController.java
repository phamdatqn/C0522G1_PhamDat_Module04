package cart_management.controller;

import cart_management.model.Product;
import cart_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String home(@PageableDefault(value = 3)Pageable pageable, @RequestParam(defaultValue = "")String search, Model model) {
        model.addAttribute("productList",iProductService.findAll(search,pageable));
        model.addAttribute("search",search);
        return "home";
    }

    @GetMapping("/detail/{id}")
    public String home(@PathVariable int id, Model model) {
        Product product = iProductService.findById(id).get();
        model.addAttribute("product",product);
        return "detail";
    }



}
