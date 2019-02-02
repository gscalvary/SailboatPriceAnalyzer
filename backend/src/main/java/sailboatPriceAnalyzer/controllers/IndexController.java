package sailboatPriceAnalyzer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sailboatPriceAnalyzer.domain.services.SailboatDataService;

@Controller
public class IndexController {

    private final SailboatDataService sailboatDataService;

    IndexController(SailboatDataService sailboatDataService) {
        this.sailboatDataService = sailboatDataService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {

        model.addAttribute("sailboatData", sailboatDataService.getSailboatData());
        return "index";
    }
}
