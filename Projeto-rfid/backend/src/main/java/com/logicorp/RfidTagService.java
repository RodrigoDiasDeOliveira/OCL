package com.logicorp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RfidTagService {
    
    @Autowired
    private RfidTagRepository rfidTagRepository;

    public List<RfidTag> getAllTags() {
        return rfidTagRepository.findAll();
    }

    public RfidTag updateTag(RfidTag tag) {
        Optional<RfidTag> existingTag = rfidTagRepository.findById(tag.getId());
        if (existingTag.isPresent()) {
            RfidTag currentTag = existingTag.get();
            currentTag.setLocation(tag.getLocation());
            currentTag.setLastScanned(LocalDateTime.now());
            return rfidTagRepository.save(currentTag);
        } else {
            throw new RuntimeException("Tag not found");
        }
    }
    public void updateTagsLocationByProduct(String productName, String newLocation) {
        List<RfidTag> tags = rfidTagRepository.findByProductName(productName);
        for (RfidTag tag : tags) {
            tag.setLocation(newLocation);
            tag.setLastScanned(LocalDateTime.now());
        }
        rfidTagRepository.saveAll(tags);
    }
    public void removeObsoleteTags() {
        List<RfidTag> obsoleteTags = rfidTagRepository.findAll().stream()
                .filter(tag -> tag.getTimeSinceLastScan() > 1440) // 1 day in minutes
                .toList();
        rfidTagRepository.deleteAll(obsoleteTags);
    }
}
