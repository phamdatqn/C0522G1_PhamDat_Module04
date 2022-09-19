package blog_management.controller;

import blog_management.model.Blog;
import blog_management.model.Category;
import blog_management.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Set;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "category/home";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/update";
    }

    @GetMapping("/select/{id}")
    public String selectCategory(@PathVariable int id, Model model) {
        Set<Blog> blogs = iCategoryService.findById(id).getBlogs();
        model.addAttribute("blogList", blogs);
        return "blog/home";
    }

    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/delete";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/update")
    public String update(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Cập nhập thành công: " + category.getCategoryName());
        return "redirect:/category";
    }

    @PostMapping("/delete")
    public String delete(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.delete(category);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công: " + category.getCategoryName());
        return "redirect:/category";
    }

    @PostMapping("/save")
    public String create(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Tạo mới thành công: " + category.getCategoryName());
        return "redirect:/category";
    }
}
