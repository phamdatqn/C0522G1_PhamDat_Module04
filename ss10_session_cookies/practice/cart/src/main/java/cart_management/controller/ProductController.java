package cart_management.controller;

import cart_management.dto.CartDto;
import cart_management.dto.ProductDto;
import cart_management.model.Product;
import cart_management.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@SessionAttributes("cart")
@Controller
@RequestMapping("/product")
public class ProductController {

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String home(@PageableDefault(value = 3) Pageable pageable,
                       @RequestParam(defaultValue = "") String search, Model model,
                       @CookieValue(value = "idProduct", defaultValue = "-1") int id) {
        if (id != -1) {
            model.addAttribute("cookiesProduct", iProductService.findById(id).get());
        }
        model.addAttribute("productList", iProductService.findAll(search, pageable));
        model.addAttribute("search", search);
        return "product/home";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id, @SessionAttribute("cart") CartDto cart, Model model) {
        Optional<Product> productDetail = iProductService.findById(id);
        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/decrease/{id}")
    public String decreaseAmount(@PathVariable int id, @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = iProductService.findById(id);
        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.amountDecrease(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = iProductService.findById(id);
        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.deleteProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/detail/{id}")
    public String home(@PathVariable int id, Model model, HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(60 * 60);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);

        Product product = iProductService.findById(id).get();
        model.addAttribute("product", product);
        return "product/detail";
    }


}
