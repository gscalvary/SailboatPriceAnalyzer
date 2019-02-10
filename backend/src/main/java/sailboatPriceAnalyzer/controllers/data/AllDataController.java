package sailboatPriceAnalyzer.controllers.data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sailboatPriceAnalyzer.domain.services.SailboatDataService;
import sailboatPriceAnalyzer.domain.valueObjects.SailboatData;

import java.util.List;

@RestController
public class AllDataController {

    private final SailboatDataService sailboatDataService;

    AllDataController(SailboatDataService sailboatDataService) {
        this.sailboatDataService = sailboatDataService;
    }

    @GetMapping("/v1/data/all.json")
    public List<SailboatData> getAllSailboatData() {

        return sailboatDataService.getSailboatData();
    }
}
