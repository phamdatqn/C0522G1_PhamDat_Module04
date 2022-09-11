package dictionary_management.controller;

import dictionary_management.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {

    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @GetMapping("search")
    public ModelAndView search(@RequestParam String search) {
        return new ModelAndView("home", "result", iDictionaryService.search(search));
    }
}
