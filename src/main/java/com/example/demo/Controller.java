package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
public class Controller {

    @Autowired
    ProviderRestService providerRestService;


    @Autowired
    ValidationResponse validationResponse;


    @PostMapping(path = "/validate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ValidationResponse validate22(@Valid @RequestBody ValidationRequest validationRequest){

        if (validationRequest.providers != null) {
            providerRestService.getResponse(validationRequest.accountNumber, validationRequest.providers);
            ValidationResponse validationResponse = new ValidationResponse();
            validationResponse.setResult(providerRestService.getResponse(validationRequest.accountNumber,  validationRequest.providers));
            return validationResponse;
        }
        else {
            providerRestService.getAll(validationRequest.accountNumber);
            ValidationResponse validationResponse = new ValidationResponse();
            validationResponse.setResult(providerRestService.getAll(validationRequest.accountNumber));
            return validationResponse;
        }

    }
}
