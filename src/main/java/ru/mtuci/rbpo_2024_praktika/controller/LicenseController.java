package ru.mtuci.rbpo_2024_praktika.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mtuci.rbpo_2024_praktika.dto.LicenseActivationDto;
import ru.mtuci.rbpo_2024_praktika.dto.LicenseCreateDto;
import ru.mtuci.rbpo_2024_praktika.service.licenses.LicenseService;

@RestController
@RequiredArgsConstructor
public class LicenseController {
    private final LicenseService licenseService;
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping ("/admin/licenses")
    public ResponseEntity<?> createLicense(@RequestBody LicenseCreateDto license){
        return licenseService.createLicense(license);
    }

//    @PatchMapping
//    public ResponseEntity<?> patchLicense(@RequestBody LicenseActivationDto licenseActivationDto){
//        return null;
//    }
}
