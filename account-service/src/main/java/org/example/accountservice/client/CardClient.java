package org.example.accountservice.client;

import org.example.accountservice.dto.CardDto;
import org.example.accountservice.dto.LoanDto;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CardClient {

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    public CardClient(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    public List<CardDto> getCardsByAccountId(Long accountId) {
        try {
            ServiceInstance instance = discoveryClient.getInstances("card-service").get(0);
            String url = instance.getUri().toString() + "/cards/accounts/" + accountId;
            
            ResponseEntity<List<CardDto>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CardDto>>() {}
            );
            
            return response.getBody();
        } catch (Exception e) {
            return null;
        }
    }
}
