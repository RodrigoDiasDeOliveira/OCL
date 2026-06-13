package com.triminds.tlp.integration.provider;

public interface IntegrationProvider {

    void pushData(Object data);

    String fetchData();
}