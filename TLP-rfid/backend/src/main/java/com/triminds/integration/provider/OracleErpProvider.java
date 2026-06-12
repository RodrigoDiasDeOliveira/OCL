package com.triminds.integration.provider;
import org.springframework.stereotype.Service;

@Service
public class OracleErpProvider {
    public int syncEntity(String entity) {
        System.out.println("🔄 Oracle ERP Sync → Entity: " + entity);
        // Implementar chamada real via Oracle REST API ou DB Link
        return 320;
    }
}