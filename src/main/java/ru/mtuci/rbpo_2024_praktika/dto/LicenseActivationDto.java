package ru.mtuci.rbpo_2024_praktika.dto;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class LicenseActivationDto {
    private UUID code;
    private UUID deviceId;
    private String deviceName;
    private String mac_address;
    private UUID userId;
}
