package login_management.controller;

import login_management.model.User;
import login_management.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import java.security.Principal;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String home(){
        return "/index";
    }

    @GetMapping("/userDetail")
    public String userDetail(Model model, Principal principal){

//        // Sau khi user login thanh cong se co principal
//        String userName = principal.getName();
//
//        System.out.println("User Name: " + userName);
//
//        User loginUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginUser);
//        model.addAttribute("userDetail", userInfo);
//
      return "userDetail";
    }
}
