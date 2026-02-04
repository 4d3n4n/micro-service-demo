package org.example.cardservice.client;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccountClient {

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    public AccountClient(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    public boolean accountExists(Long accountId) {
        try {
            ServiceInstance instance = discoveryClient.getInstances("account-service").get(0);
            String url = instance.getUri().toString() + "/accounts/" + accountId;
            restTemplate.getForObject(url, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
