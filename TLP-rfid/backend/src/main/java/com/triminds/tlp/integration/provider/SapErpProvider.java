package com.triminds.tlp.integration.provider;
import org.springframework.stereotype.Service;

@Service
public class SapErpProvider {
    public int syncEntity(String entity) {
        System.out.println("🔄 SAP S/4HANA Sync → Entity: " + entity);
        return 245;
    }
}