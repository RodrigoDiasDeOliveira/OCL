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
        try {
            return rfidTagService.updateTag(tag);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found", e);
        }
    }
    @PostMapping("/update-location")
    public void updateTagsLocationByProduct(@RequestParam String productName, @RequestParam String newLocation) {
        rfidTagService.updateTagsLocationByProduct(productName, newLocation);
    }

    @DeleteMapping("/remove-obsolete")
    public void removeObsoleteTags() {
        rfidTagService.removeObsoleteTags();
    }

    @GetMapping("/location/{tagId}")
    public RfidTag getTagLocation(@PathVariable String tagId) {
        return rfidTagService.getTagLocation(tagId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found"));
    }
}
