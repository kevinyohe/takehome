package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
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
public class ProviderConfig implements CommandLineRunner {
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
                System.out.println("Found it!!!");
                return entry.get("url");
            }
        }
       return "";
    }

    @Override
    public void run(String... args) throws Exception{

        System.out.println(this.providers.get(0));
        this.providers.forEach(item -> item.forEach((k,v) -> System.out.println(k + ": " + v)));
        System.out.println(this.resolveProviderUrl("provider22"));
        System.out.println(this.resolveProviderUrl("provider1"));
        System.out.println(this.providers);
    }
}
