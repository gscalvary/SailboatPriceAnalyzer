package sailboatPriceAnalyzer.domain.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sailboatPriceAnalyzer.domain.valueObjects.SailboatData;

import java.util.List;

@Service
public class SailboatDataService {

    @Value("${sailboatAdScraperService.url}")
    private String url;

    private RestTemplate restTemplate;

    SailboatDataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<SailboatData> getSailboatData() {

        ResponseEntity<List<SailboatData>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<SailboatData>>(){}
        );

        return responseEntity.getBody();
    }
}
