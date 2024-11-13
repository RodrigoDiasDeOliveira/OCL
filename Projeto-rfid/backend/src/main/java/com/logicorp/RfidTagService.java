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
        return rfidTagRepository.save(tag);
    }
}
