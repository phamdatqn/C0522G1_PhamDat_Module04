package medical_declaration_management.controller;

import medical_declaration_management.model.Declaration;
import medical_declaration_management.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DeclarationController {

    @Autowired
    private IDeclarationService iDeclarationService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Declaration> declarationList = iDeclarationService.displayAll();
        model.addAttribute("declarationList",declarationList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model){
        List<String>genderList= iDeclarationService.gender();
        List<String>countryList= iDeclarationService.country();
        model.addAttribute("declaration",new Declaration());
        model.addAttribute("genderList",genderList);
        model.addAttribute("countryList",countryList);
        return "create";
    }
}
