// src/main/java/com/triminds/integration/service/ErpIntegrationService.java
package com.triminds.integration.service;

import com.triminds.integration.provider.OracleErpProvider;
import com.triminds.integration.provider.SapErpProvider;
import com.triminds.integration.provider.TotvsErpProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ErpIntegrationService {

    private final OracleErpProvider oracleProvider;
    private final SapErpProvider sapProvider;
    private final TotvsErpProvider totvsProvider;

    public int syncFromErp(String erp, String entity) {
        return switch (erp.toLowerCase()) {
            case "oracle" -> oracleProvider.syncEntity(entity);
            case "sap" -> sapProvider.syncEntity(entity);
            case "totvs" -> totvsProvider.syncEntity(entity);
            default -> throw new IllegalArgumentException("ERP não suportado: " + erp);
        };
    }
}