package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Component
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="providers")
public class ProviderRestService implements CommandLineRunner {

    @Autowired
    private ProviderConfig providerConfig;

    @Autowired
    private ProviderResponse providerResponse;

    @Autowired
    private ValidationResponse validationResponse;

    @Autowired
    private List<ProviderResponse> listResponses;

    public List<ProviderResponse> getResponse(String account, List<String> provider) {
        List<ProviderResponse> listResponses2 = new ArrayList<>();
        if (provider != null) {
            for (String item : provider) {
                boolean resp = this.callRestService(account, providerConfig.resolveProviderUrl(item));
                ProviderResponse providerResponse2 = new ProviderResponse();
                providerResponse2.setProviderName(item);
                providerResponse2.setValid(resp);
                listResponses2.add(providerResponse2);
            }
        }
        return listResponses2;
    }

    public List<ProviderResponse> getAll(String account){
        List<ProviderResponse> listResponses2 = new ArrayList<>();
        //for
        for (Map<String, String> entry: providerConfig.getProviders()){
            System.out.println(entry);
            boolean reply = this.callRestService(account, entry.get("url"));
            ProviderResponse providerResponse2 = new ProviderResponse();
            providerResponse2.setProviderName(entry.get("name"));
            providerResponse2.setValid(reply);
            listResponses2.add(providerResponse2);
        }

        System.out.println(listResponses2.toArray());
        validationResponse.setResult(listResponses2);

        return listResponses2;
    }

    public ProviderResponse getResponse(String account){
        return this.providerResponse;
    }

    public boolean callRestService(String account, String url) {

        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getForObject("http://localhost:80", String response);
        System.out.println("will use " + url + " and " + account);
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            System.out.println(response);
        } catch (Exception e){
            System.out.println("Exception on validation: " + e);
        }
        return false;
    }

    @Override
    public void run(String... args) {
        System.out.println("delete me");
    }


}
