package case_study_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/furama")
public class MainController {

    @GetMapping()
    public String home() {
        return "home";
    }
}
