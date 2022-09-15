package music_management.controller;

import music_management.model.Music;
import music_management.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping("")
    public String home(Model model) {
        List<Music> musicList = iMusicService.displayAll();
        model.addAttribute("musicList", musicList);
        return "home";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "delete";
    }

    @GetMapping("/search/")
    public String search(@RequestParam String search, Model model) {
        List<Music> musicList;
        if (StringUtils.hasText(search)) {
            musicList = iMusicService.searchByName(search);
            model.addAttribute("message", "Bạn đang tìm thông tin liên quan đến: " + search);
            model.addAttribute("musicList", musicList);
        } else {
            model.addAttribute("message", "Vui lòng nhập từ khóa để tìm kiếm !");
            musicList = iMusicService.displayAll();
            model.addAttribute("musicList", musicList);
        }
        return "home";
    }

    @GetMapping("/detail/{id}")
    public String showInfo(@PathVariable int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "detail";
    }


    @PostMapping("/save")
    public String save(Music music, RedirectAttributes redirectAttributes) {
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công bài hát: " + music.getNameMusic());
        return "redirect:/music";
    }

    @PostMapping("/update")
    public String update(Music music, RedirectAttributes redirectAttributes) {
        iMusicService.update(music);
        redirectAttributes.addFlashAttribute("message", "Cập nhập thành công bài hát: " + music.getNameMusic());
        return "redirect:/music";
    }

    @PostMapping("/delete")
    public String delete(Music music, RedirectAttributes redirectAttributes) {
        iMusicService.delete(music.getId());
        redirectAttributes.addFlashAttribute("message", "Xóa thành công bài hát: " + music.getNameMusic());
        return "redirect:/music";
    }
}
