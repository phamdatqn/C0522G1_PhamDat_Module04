package smartphone_management.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import smartphone_management.dto.SmartphoneDto;
import smartphone_management.model.Smartphone;
import smartphone_management.service.ISmartphoneService;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:63343")
@RequestMapping("/api/smartphone")
public class SmartphoneController {

    @Autowired
    private ISmartphoneService iSmartphoneService;

    @GetMapping()
    public ResponseEntity<List<Smartphone>> home() {
        List<Smartphone> smartphoneList = iSmartphoneService.findAll();
        if (smartphoneList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphoneList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Smartphone> addSmartphone(@RequestBody SmartphoneDto smartphoneDto){
        Smartphone smartphone = new Smartphone();
        BeanUtils.copyProperties(smartphoneDto,smartphone);
        iSmartphoneService.save(smartphone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
