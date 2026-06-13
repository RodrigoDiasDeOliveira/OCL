
package com.triminds.tlp.analytics.service;

import com.triminds.tlp.rfid.repository.RfidEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final RfidEventRepository eventRepository;

    public Map<String, Object> getWarehouseKpis(String companyId) {
        Map<String, Object> kpis = new HashMap<>();

        LocalDateTime since24h = LocalDateTime.now().minusHours(24);

        kpis.put("totalEventsLast24h", eventRepository.countEventsLast24h(companyId, since24h));
        kpis.put("activeTags", eventRepository.countActiveTags(companyId));
        kpis.put("throughputPerHour", calculateThroughput(companyId));
        kpis.put("bottleneckZones", detectBottlenecks(companyId));
        kpis.put("avgDwellTimeMinutes", 42);

        return kpis;
    }

    private double calculateThroughput(String companyId) {
        return 245.5;
    }

    private List<String> detectBottlenecks(String companyId) {
        return List.of("Zona-B", "Doca-3");
    }
}
