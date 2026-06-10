package com.logicorp.rfid.service;

import com.logicorp.rfid.model.RfidTag;
import com.logicorp.rfid.repository.RfidTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RfidOperationService {

    @Autowired
    private RfidTagRepository repository;

    // 📌 atualizar localização por produto
    public void updateTagsLocationByProduct(String productName, String newLocation) {

        List<RfidTag> tags = repository.findByProductName(productName);

        for (RfidTag tag : tags) {
            tag.setLocation(newLocation);
        }

        repository.saveAll(tags);
    }

    // 📌 remover tags antigas (obsoletas)
    public void removeObsoleteTags() {

        LocalDateTime limit = LocalDateTime.now().minusDays(30);

        List<RfidTag> oldTags = repository.findByLastScannedBefore(limit);

        repository.deleteAll(oldTags);
    }

    // 📌 mover tag individual (operação logística)
    public RfidTag moveTag(String tagId, String newLocation) {

        RfidTag tag = repository.findByTagId(tagId)
                .orElseThrow(() -> new RuntimeException("Tag not found"));

        tag.setLocation(newLocation);

        return repository.save(tag);
    }
}