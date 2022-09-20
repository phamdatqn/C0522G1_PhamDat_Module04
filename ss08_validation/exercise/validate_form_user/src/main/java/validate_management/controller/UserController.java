package validate_management.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import validate_management.dto.UserDto;
import validate_management.model.User;
import validate_management.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String home(@PageableDefault(value = 2) Pageable pageable, Model model, @RequestParam(defaultValue = "") String search) {
        model.addAttribute("userList", iUserService.findAll(pageable));
        model.addAttribute("search", search);
        return "home";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasFieldErrors())
            return "/create";
        else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);
            redirectAttributes.addFlashAttribute("message", "Thêm mới " + user.getLastName() + " thành công !");
            return "redirect:/user";
        }


    }
}
