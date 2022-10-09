package case_study_management.controller;

import case_study_management.dto.ContractDetailDto;
import case_study_management.model.contract.ContractDetail;
import case_study_management.service.contract.IContractDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {

    @Autowired
    private IContractDetailService iContractDetailService;

    @PostMapping("/create")
    public String createContractDetail(@ModelAttribute ContractDetailDto contractDetailDto, RedirectAttributes redirectAttributes) {
        ContractDetail contractDetail = new ContractDetail();

        BeanUtils.copyProperties(contractDetailDto, contractDetail);

        iContractDetailService.save(contractDetail);

        redirectAttributes.addFlashAttribute("message", "Thêm mới hợp đồng chi tiết thành công !");
        return "redirect:/contract";
    }
}
