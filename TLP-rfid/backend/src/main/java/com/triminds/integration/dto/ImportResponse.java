package com.triminds.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportResponse {

    private boolean success;
    private int recordsImported;
    private String message;
    private String source;
    private String fileName;
    private String timestamp;

    public static ImportResponse success(int records, String source, String fileName) {
        return new ImportResponse(
            true,
            records,
            "Importação realizada com sucesso",
            source,
            fileName,
            java.time.LocalDateTime.now().toString()
        );
    }

    public static ImportResponse error(String message, String source) {
        return new ImportResponse(
            false,
            0,
            message,
            source,
            null,
            java.time.LocalDateTime.now().toString()
        );
    }
}