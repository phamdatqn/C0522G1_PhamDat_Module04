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
    public String home(@PageableDefault(value = 2)Pageable pageable, Model model,
                       @RequestParam(defaultValue = "")String search){
        model.addAttribute("musicList",iMusicService.findAll(pageable));
        model.addAttribute("search",search);
        return "home";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "/create";
    }

    @PostMapping("/create")
    public  String save(@ModelAttribute @Validated MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()){
            return "create";
        }
        else {
            Music music=new Music();
            BeanUtils.copyProperties(musicDto,music);
            iMusicService.save(music);
            redirectAttributes.addFlashAttribute("message","Thêm mới bài hát: "+music.getMusicName()+ " Thành công !");
            return "redirect:/music";
        }

    }
}
