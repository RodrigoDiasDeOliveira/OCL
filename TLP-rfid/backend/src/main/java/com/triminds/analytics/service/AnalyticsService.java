package com.triminds.tlp.analytics.service;

import com.triminds.tlp.rfid.repository.RfidEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final RfidEventRepository eventRepository;

    public Map<String, Object> getWarehouseKpis(String companyId) {
        Map<String, Object> kpis = new HashMap<>();
        kpis.put("totalEventsLast24h", eventRepository.countEventsLast24h(companyId));
        kpis.put("activeTags", eventRepository.countActiveTags(companyId));
        kpis.put("throughputPerHour", 245); // exemplo
        kpis.put("bottleneckZones", List.of("Zona B", "Doca 3"));
        return kpis;
    }
}
