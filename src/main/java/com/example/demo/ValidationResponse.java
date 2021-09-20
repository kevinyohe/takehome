package com.example.demo;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidationResponse {
    public List<ProviderResponse> getResult() {
        return result;
    }

    public void setResult(List<ProviderResponse> result) {
        this.result = result;
    }

    private List<ProviderResponse> result;

}
