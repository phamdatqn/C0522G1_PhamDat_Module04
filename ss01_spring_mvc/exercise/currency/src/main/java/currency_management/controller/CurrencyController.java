package currency_management.controller;

import currency_management.service.ICurrenCyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyController {

    @Autowired
    private ICurrenCyService iCurrenCyService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @PostMapping("result")
    public ModelAndView convert(@RequestParam int inputNumber){
        return new ModelAndView("index","result",iCurrenCyService.convert(inputNumber));
    }
}
