package com.triminds.tlp.integration.controller;

import com.triminds.tlp.integration.service.ErpIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/integration/erp")
@RequiredArgsConstructor
public class ErpIntegrationController {

    private final ErpIntegrationService erpService;

    @PostMapping("/sync")
    public ResponseEntity<String> syncFromErp(@RequestBody Map<String, String> request) {
        String erp = request.get("erp");      // oracle, sap, totvs
        String entity = request.get("entity"); // inventory, sales, orders...

        int records = erpService.syncFromErp(erp, entity);
        return ResponseEntity.ok("Sincronização com " + erp.toUpperCase() + " concluída: " + records + " registros");
    }
}