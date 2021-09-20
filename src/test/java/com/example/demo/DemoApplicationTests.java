package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.ValidationRequest;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void contextLoads2() {
        assert 1 == 1;
        System.out.println("DID IT");
    }

    @Test
    void CreateValidationRequest(){
        ValidationRequest a = new ValidationRequest("123456");
        assert a.accountNumber == "123456";
        assert a.hasProviders() == false;
    }

    @Test
    void CreateValidationRequestProviders(){
        List providers = new ArrayList<String>();
        providers.add("http://visa.com/api/validate");
        ValidationRequest a = new ValidationRequest("33333", providers);
        assert a.accountNumber == "33333";
        assert a.providers.contains("http://visa.com/api/validate");
        assert a.providers.size() == 1;
        assert a.hasProviders();
    }

    @Test
    void TestProviderRestService(){
        ProviderRestService a = new ProviderRestService();
        ProviderResponse pR = new ProviderResponse();


    }
}
