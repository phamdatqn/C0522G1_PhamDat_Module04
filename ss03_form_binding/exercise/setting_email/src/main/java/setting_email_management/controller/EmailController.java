package setting_email_management.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import setting_email_management.model.Email;
import setting_email_management.service.IEmailService;

import java.util.List;

@Controller
public class EmailController {

    @Autowired
    private IEmailService iEmailService;

    @GetMapping("/")
    public String home(Model model) {
        List<Email> emailList = iEmailService.displayAll();
        model.addAttribute("emailList", emailList);

        return "home";
    }

    @GetMapping("/update/{id}")
    public ModelAndView showInfo(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("update");

        Email email = iEmailService.findById(id);
        List<String> languagesList = iEmailService.languagesList();
        List<Integer> pageSizeList = iEmailService.pagaSizeList();

        modelAndView.addObject("email", email);
        modelAndView.addObject("languagesList", languagesList);
        modelAndView.addObject("pageSizeList", pageSizeList);

        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Email email) {
        iEmailService.save(email);
        return "redirect:/";
    }
}
