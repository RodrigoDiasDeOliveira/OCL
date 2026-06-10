package com.logicorp.rfid.service;

import com.logicorp.rfid.model.RfidTag;
import com.logicorp.rfid.repository.RfidTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RfidTagService {

    @Autowired
    private RfidTagRepository rfidTagRepository;

    public List<RfidTag> getAllTags() {
        return rfidTagRepository.findAll();
    }

    public RfidTag updateTag(RfidTag tag) {
        return rfidTagRepository.save(tag);
    }

    public void updateTagsLocationByProduct(String productName, String newLocation) {
        List<RfidTag> tags = rfidTagRepository.findByProductName(productName);
        for (RfidTag tag : tags) {
            tag.setLocation(newLocation);
        }
        rfidTagRepository.saveAll(tags);
    }

    public void removeObsoleteTags() {
        LocalDateTime limit = LocalDateTime.now().minusDays(30);
        List<RfidTag> oldTags = rfidTagRepository.findByLastScannedBefore(limit);
        rfidTagRepository.deleteAll(oldTags);
    }

    public Optional<RfidTag> getTagLocation(String tagId) {
        return rfidTagRepository.findByTagId(tagId);
    }
}