package com.triminds.rfid.repository;

import com.triminds.rfid.model.RfidTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RfidTagRepository extends JpaRepository<RfidTag, Long> {

    Optional<RfidTag> findByTagId(String tagId);

    List<RfidTag> findByProductName(String productName);

    // Opcional: buscar tags antigas (para limpeza)
    List<RfidTag> findByLastScannedBefore(java.time.LocalDateTime dateTime);
}