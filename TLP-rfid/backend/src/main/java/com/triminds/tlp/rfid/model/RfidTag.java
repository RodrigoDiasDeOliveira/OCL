package com.triminds.tlp.rfid.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "rfid_tags")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RfidTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank
    private String tagId;

    private String productName;

    private String location;

    private LocalDateTime lastScanned;

    // Relacionamento com eventos (opcional, mas recomendado)
    // @OneToMany(mappedBy = "rfidTag")
    // private List<RfidEvent> events;
}