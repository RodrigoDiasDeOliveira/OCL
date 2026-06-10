package com.triminds.integration.provider;

public interface IntegrationProvider {

    void pushData(Object data);

    String fetchData();
}