package sailboatPriceAnalyzer.controllers.data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sailboatPriceAnalyzer.domain.factories.MakeByLengthByYearFactory;
import sailboatPriceAnalyzer.domain.services.SailboatDataService;

import java.util.Map;

@RestController
public class MakeLengthYearDataController {

    private final SailboatDataService sailboatDataService;
    private final MakeByLengthByYearFactory makeByLengthByYearFactory;

    MakeLengthYearDataController(SailboatDataService sailboatDataService,
                                 MakeByLengthByYearFactory makeByLengthByYearFactory) {
        this.sailboatDataService = sailboatDataService;
        this.makeByLengthByYearFactory = makeByLengthByYearFactory;
    }

    @GetMapping("/v1/data/makebylengthbyyear.json")
    public Map<String, Map<Float, Map<Integer, Float>>> getMakeByLengthByYearData() {

        return makeByLengthByYearFactory.build(sailboatDataService.getSailboatData());
    }
}
