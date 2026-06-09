package com.logicorp;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Setter
public class RfidTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String tagId;

    @NotNull
    private String productName;

    @NotNull
    private String location;

    private LocalDateTime lastScanned;

    public long getTimeSinceLastScan() {
        if (lastScanned == null) return -1;
        return ChronoUnit.MINUTES.between(lastScanned, LocalDateTime.now());
    }
}