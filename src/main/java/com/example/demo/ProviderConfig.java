package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Component
public class ProviderConfig {
    public List<Map<String, String>> getProviders() {
        return providers;
    }

    public void setProviders(List<Map<String, String>> providers) {
        this.providers = providers;
    }

    private List<Map<String, String>> providers;

    // Provide url for name of provider.
    public String resolveProviderUrl(String name){
        for(Map<String, String> entry : this.providers) {
            System.out.println(entry + " entry!");
            if(entry.get("name").equals(name)){
                return entry.get("url");
            }
        }
       return "";
    }

}
