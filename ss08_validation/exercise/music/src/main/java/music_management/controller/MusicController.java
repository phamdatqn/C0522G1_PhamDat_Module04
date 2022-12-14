package music_management.controller;

import music_management.dto.MusicDto;
import music_management.model.Music;
import music_management.service.IMusicService;
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

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping("")
    public String home(@PageableDefault(value = 2) Pageable pageable, Model model,
                       @RequestParam(defaultValue = "") String search) {
        model.addAttribute("musicList", iMusicService.findByName(search, pageable));
        model.addAttribute("search", search);
        return "home";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "/create";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model) {
        Music music = iMusicService.findById(id);
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(music, musicDto);
        model.addAttribute("musicDto", musicDto);
        return "/update";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute @Validated MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            iMusicService.save(music);
            redirectAttributes.addFlashAttribute("message", "Th??m m???i b??i h??t: " + music.getMusicName() + " Th??nh c??ng !");
            return "redirect:/music";
        }
    }

    @PostMapping("/update")
    public String update(MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "/update";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            iMusicService.save(music);
            redirectAttributes.addFlashAttribute("message", "c???p nh???p b??i h??t: " + music.getMusicName() + " Th??nh c??ng !");
            return "redirect:/music";
        }
    }
}
