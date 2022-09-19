package blog_management.blog.controller;

import blog_management.blog.model.Blog;
import blog_management.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String home(@PageableDefault(value = 3)Pageable pageable,Model model) {

        Page<Blog> blogList = iBlogService.findAll(pageable);
        model.addAttribute("blogList", blogList);

        return "home";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blogList", new Blog());
        return "create";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "update";
    }

    @GetMapping("/detail/{id}")
    public String showFormDetail(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "delete";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công: " + blog.getName());
        return "redirect:/blog";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Cập nhập thành công: " + blog.getName());
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.delete(blog);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công: " + blog.getName());
        return "redirect:/blog";
    }
}
