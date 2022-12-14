package blog_management.controller;

import blog_management.model.Blog;
import blog_management.service.IBlogService;
import blog_management.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/dto")
    public String homeDto(Model model) {
        model.addAttribute("blogListDto", iBlogService.findByNameDto());
        return "blog/homeDto";
    }

    @GetMapping("")
    public String home(@PageableDefault(value = 2, sort = "date_of_writing") Pageable pageable,
                       Model model, @RequestParam(defaultValue = "") String search) {
        model.addAttribute("blogList", iBlogService.findByName(search, pageable));
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("search", search);
        return "blog/home";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blogList", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "blog/create";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "blog/update";
    }

    @GetMapping("/detail/{id}")
    public String showFormDetail(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findAll());
        model.addAttribute("blogInfo", iBlogService.findById(id));
        return "blog/detail";
    }

    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "blog/delete";
    }

    @GetMapping("/select/{idCategory}")
    public String chooseSelect(@PageableDefault(value = 2, sort = "date_of_writing") Pageable pageable,
                               Model model, @PathVariable int idCategory) {
        model.addAttribute("blogList", iBlogService.findByCategory(idCategory, pageable));
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("search", idCategory);
        return "blog/home";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Th??m m???i th??nh c??ng: " + blog.getTitle());
        return "redirect:/blog";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "C???p nh???p th??nh c??ng: " + blog.getTitle());
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.delete(blog);
        redirectAttributes.addFlashAttribute("message", "X??a th??nh c??ng: " + blog.getTitle());
        return "redirect:/blog";
    }


}
