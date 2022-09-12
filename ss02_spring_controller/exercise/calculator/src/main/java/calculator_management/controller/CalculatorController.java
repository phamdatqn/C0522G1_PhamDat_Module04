package calculator_management.controller;

import calculator_management.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/calculation")
    public ModelAndView addition(@RequestParam String inputNumber1,@RequestParam String inputNumber2, String calculation){
        return new ModelAndView("index","result",iCalculatorService.calculator(inputNumber1,inputNumber2,calculation));
    }
}
