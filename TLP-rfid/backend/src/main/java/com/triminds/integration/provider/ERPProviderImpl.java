package com.triminds.integration.provider;

import org.springframework.stereotype.Component;

@Component
public class ERPProviderImpl implements IntegrationProvider {

    @Override
    public void pushData(Object data) {
        System.out.println("Sending to ERP...");
    }

    @Override
    public String fetchData() {
        return "ERP data";
    }
}