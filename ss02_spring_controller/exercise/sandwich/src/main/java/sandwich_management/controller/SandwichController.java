package sandwich_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment", defaultValue = "") String[] condiment, Model model) {
        System.out.println(condiment.length);
        if (condiment.length == 0) {
            model.addAttribute("condiment", "Bạn chưa chọn !");
        } else {
            model.addAttribute("condiment", condiment);
        }
        return "order";
    }
}
