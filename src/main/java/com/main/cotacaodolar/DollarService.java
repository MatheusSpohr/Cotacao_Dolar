package com.main.cotacaodolar;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DollarService {

    private final String projeto2Url = "http://localhost:5000/getDollarRate";

    public void requestDollarRate() {
        RestTemplate restTemplate = new RestTemplate();
        String dollarRate = restTemplate.getForObject(projeto2Url, String.class);
        System.out.println("Cotação do Dólar: " + dollarRate);
    }
}
