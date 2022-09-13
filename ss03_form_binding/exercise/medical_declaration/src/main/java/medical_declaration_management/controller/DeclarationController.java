package medical_declaration_management.controller;

import medical_declaration_management.model.Declaration;
import medical_declaration_management.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DeclarationController {

    @Autowired
    private IDeclarationService iDeclarationService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Declaration> declarationList = iDeclarationService.displayAll();
        model.addAttribute("declarationList", declarationList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<String> genderList = iDeclarationService.gender();
        List<String> countryList = iDeclarationService.country();
        List<String> vehicleList = iDeclarationService.phuongTien();
        model.addAttribute("declaration", new Declaration());
        model.addAttribute("genderList", genderList);
        model.addAttribute("countryList", countryList);
        model.addAttribute("vehicleList", vehicleList);
        return "create";
    }

    @GetMapping("/update/{id}")
    public ModelAndView showInfo(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("update");
        Declaration declaration = iDeclarationService.findById(id);
        List<String> genderList = iDeclarationService.gender();
        List<String> countryList = iDeclarationService.country();
        List<String> vehicleList = iDeclarationService.phuongTien();

        modelAndView.addObject("genderList", genderList);
        modelAndView.addObject("countryList", countryList);
        modelAndView.addObject("vehicleList", vehicleList);
        modelAndView.addObject("declaration", declaration);
        return modelAndView;
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Declaration declaration, RedirectAttributes redirectAttributes) {
        iDeclarationService.create(declaration);
        redirectAttributes.addFlashAttribute("message", "Tờ khai " + declaration.getName() + " thêm mới thành công! ");
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Declaration declaration) {
        iDeclarationService.update(declaration);
        return "redirect:/";
    }
}
