package com.example.productreview.service;

import com.example.productreview.model.dto.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class ExchangeRateService {

    @Value("${hnb.api.url}")
    private String hnbApiUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public ExchangeRateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BigDecimal convertEurToUsd(BigDecimal eurAmount) {
        try {
            ResponseEntity<List<ExchangeRateResponse>> responseEntity = restTemplate.exchange(
                    hnbApiUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ExchangeRateResponse>>() {}
            );

            List<ExchangeRateResponse> exchangeRates = responseEntity.getBody();

            if (exchangeRates != null && !exchangeRates.isEmpty()) {
                ExchangeRateResponse usdRate = exchangeRates.get(0);

                BigDecimal usdToEurRate = new BigDecimal(usdRate.getMiddleRate().replace(",", "."));

                BigDecimal amountInUsd = eurAmount.multiply(usdToEurRate).setScale(2, RoundingMode.HALF_UP);

                return amountInUsd;
            } else {
                throw new RuntimeException("No exchange rates received from HNB API");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error converting EUR to USD: " + e.getMessage(), e);
        }
    }
}