package com.example.demo;

import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;


import javax.validation.constraints.NotEmpty;
import java.util.List;

@Validated
public class ValidationRequest {
    @NotNull
    @NotEmpty
    public String accountNumber;

    public List<String> providers;

    public ValidationRequest(String accountNumber, List<String> providers) {
        this.accountNumber = accountNumber;
        this.providers = providers;
    }

    public ValidationRequest(String accountNumber) {
        this.accountNumber = accountNumber;
        this.providers = null;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<String> getProviders() {
        return providers;
    }

    public void setProviders(List<String> providers) {
        this.providers = providers;
    }

    public boolean hasProviders(){
        if (this.providers != null){
            return true;
        }
        else {
            return false;
        }
    }
}
