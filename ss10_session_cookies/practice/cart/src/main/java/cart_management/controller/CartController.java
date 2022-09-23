package cart_management.controller;

import cart_management.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("")
    public String showCart(@SessionAttribute(name = "cart", required = false) CartDto cart, Model model) {
        model.addAttribute("cart", cart);
        return "cart/home";
    }
}
