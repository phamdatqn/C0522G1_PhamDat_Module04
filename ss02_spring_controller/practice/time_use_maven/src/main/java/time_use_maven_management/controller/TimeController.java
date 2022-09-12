package time_use_maven_management.controller;

@Controller
public class TimeController {

    @GetMapping("/world-clock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        return "index";
    }
}