package ru.mtuci.rbpo_2024_praktika.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.util.UUID;

@Data
@AllArgsConstructor
public class LicenseCreateDto {
    private UUID productId;
    private UUID ownerId;
    private UUID licenseTypeId;
    private Duration duration;
    private int deviceCount;
    private String description;
}
