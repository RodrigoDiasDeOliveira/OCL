package com.logicorp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rfid")
public class RfidTagController {

    @Autowired
    private RfidTagService rfidTagService;

    @GetMapping
    public List<RfidTag> getAllTags() {
        return rfidTagService.getAllTags();
    }

    @PostMapping("/update")
    public RfidTag updateTag(@RequestBody RfidTag tag) {
        return rfidTagService.updateTag(tag);
    }
}
