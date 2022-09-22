package book_management.controller;

import book_management.exception.BookIdException;
import book_management.exception.BookNullException;
import book_management.model.Book;
import book_management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping("")
    public String home(@PageableDefault(value = 3) Pageable pageable,
                       @RequestParam(defaultValue = "") String search, Model model) {
        model.addAttribute("bookList", iBookService.findAllPage(search, pageable));
        model.addAttribute("search", search);
        return "home";
    }

    @GetMapping("/create")
    public String showFomrCreate(Model model) {
        model.addAttribute("newBook", new Book());
        return "/create";
    }

    @GetMapping("/update/{id}")
    public String showFomrUpdate(@PathVariable int id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "/update";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "/detail";
    }

    @GetMapping("/pay")
    public String showFormPay(@RequestParam int bookId, Model model) throws BookIdException {
        if (iBookService.findById(bookId) == null) {
            throw new BookIdException();
        } else {
            model.addAttribute("book", iBookService.findById(bookId));
            return "pay";
        }
    }

    @PostMapping("/create")
    public String Create(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("message", "Thêm mới sách: " + book.getBookName() + " thành công !");
        return "redirect:/book";
    }

    @PostMapping("/update")
    public String pointcutUpdate(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("message", "cập nhập sách: " + book.getBookName() + " thành công !");
        return "redirect:/book";
    }

    @PostMapping("/borrow/{id}")
    public String pointcutBorrow(@PathVariable int id, RedirectAttributes redirectAttributes) throws BookIdException, BookNullException {
        if (iBookService.findById(id) == null) {
            throw new BookIdException();
        } else {
            Book book = iBookService.findById(id);
            if (book.getAmount() == 0) {
                throw new BookNullException();
            } else {
                book.setAmount(book.getAmount() - 1);
                iBookService.save(book);
                redirectAttributes.addFlashAttribute("message", "Bạn đã mượn : " + book.getBookName() + " thành công !");
                return "redirect:/book";
            }
        }
    }

    @PostMapping("/pay/{id}")
    public String pointcutPay(@PathVariable int id, RedirectAttributes redirectAttributes) throws BookIdException {
        if (iBookService.findById(id) == null) {
            throw new BookIdException();
        } else {
            Book book = iBookService.findById(id);
            book.setAmount(book.getAmount() + 1);
            iBookService.save(book);
            redirectAttributes.addFlashAttribute("message", "Chúc mừng! bạn đã trả sách: " + book.getBookName() + " thành công !");
            return "redirect:/book";
        }
    }
}
