
package com.triminds.tlp.rfid.repository;

import com.triminds.tlp.rfid.entity.RfidEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RfidEventRepository extends JpaRepository<RfidEvent, Long> {

    List<RfidEvent> findTopByCompanyIdOrderByTimestampDesc(String companyId, int limit);

    @Query("SELECT COUNT(e) FROM RfidEvent e WHERE e.companyId = :companyId AND e.timestamp > :since")
    long countEventsLast24h(@Param("companyId") String companyId, @Param("since") LocalDateTime since);

    @Query("SELECT COUNT(DISTINCT e.tagId) FROM RfidEvent e WHERE e.companyId = :companyId")
    long countActiveTags(@Param("companyId") String companyId);

    List<RfidEvent> findByCompanyIdAndLocationAndTimestampBetween(
        String companyId, String location, LocalDateTime start, LocalDateTime end);
}
