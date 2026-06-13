package com.triminds.tlp.integration.service;

import com.triminds.tlp.rfid.model.RfidEvent;
import com.triminds.tlp.rfid.repository.RfidEventRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileImportService {

    private final RfidEventRepository rfidRepository;

    public int importFile(MultipartFile file, String type) throws Exception {
        return switch (type.toLowerCase()) {
            case "csv" -> importCsv(file);
            case "json" -> importJson(file);
            case "xml" -> importXml(file);
            default -> throw new IllegalArgumentException("Tipo de arquivo não suportado: " + type);
        };
    }

    private int importCsv(MultipartFile file) throws Exception {
        List<RfidEvent> events = new ArrayList<>();

        try (CSVParser parser = new CSVParser(new InputStreamReader(file.getInputStream()),
                CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            for (CSVRecord record : parser) {
                RfidEvent event = new RfidEvent();
                event.setTagId(record.get("tagId"));
                event.setLocation(record.get("location"));
                event.setAction(record.get("action"));
                event.setTimestamp(LocalDateTime.now());
                if (record.isMapped("item")) {
                    // event.setItem(record.get("item"));
                }
                events.add(event);
            }
        }
        rfidRepository.saveAll(events);
        return events.size();
    }

    private int importJson(MultipartFile file) {
        // TODO: Implementar com ObjectMapper
        System.out.println("JSON import recebido: " + file.getOriginalFilename());
        return 0;
    }

    private int importXml(MultipartFile file) {
        // TODO: Implementar com JAXB ou Jackson XML
        System.out.println("XML import recebido: " + file.getOriginalFilename());
        return 0;
    }
}