package com.triminds.integration.provider;
import org.springframework.stereotype.Service;

@Service
public class TotvsErpProvider {
    public int syncEntity(String entity) {
        System.out.println("🔄 TOTVS Sync → Entity: " + entity);
        return 410;
    }
}