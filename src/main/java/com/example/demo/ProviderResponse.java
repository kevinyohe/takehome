package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class ProviderResponse {
    private String providerName;
    private boolean isValid;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
