package com.triminds.tlp.integration.controller;

import com.triminds.tlp.integration.dto.ImportResponse;
import com.triminds.tlp.integration.service.FileImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/integration/files")
@RequiredArgsConstructor
public class FileImportController {

    private final FileImportService fileImportService;

    @PostMapping("/upload")
    public ResponseEntity<ImportResponse> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("type") String type) {

        try {
            int records = fileImportService.importFile(file, type);
            return ResponseEntity.ok(ImportResponse.success(records, type, file.getOriginalFilename()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ImportResponse.error(e.getMessage(), type));
        }
    }
}