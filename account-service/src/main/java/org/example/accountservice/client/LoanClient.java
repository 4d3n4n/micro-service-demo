package org.example.accountservice.client;

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
public class LoanClient {

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    public LoanClient(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    public List<LoanDto> getLoansByAccountId(Long accountId) {
        try {
            ServiceInstance instance = discoveryClient.getInstances("loans-service").get(0);
            String url = instance.getUri().toString() + "/loans/accounts/" + accountId;
            
            ResponseEntity<List<LoanDto>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<LoanDto>>() {}
            );
            
            return response.getBody();
        } catch (Exception e) {
            return null;
        }
    }
}
