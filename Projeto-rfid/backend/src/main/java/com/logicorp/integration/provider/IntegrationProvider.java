package com.logicorp.integration.provider;

public interface IntegrationProvider {

    void pushData(Object data);

    String fetchData();
}