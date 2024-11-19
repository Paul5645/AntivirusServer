package ru.mtuci.rbpo_2024_praktika.service.licenses;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.mtuci.rbpo_2024_praktika.dto.LicenseCreateDto;
import ru.mtuci.rbpo_2024_praktika.exceptions.AppError;
import ru.mtuci.rbpo_2024_praktika.model.ApplicationUser;
import ru.mtuci.rbpo_2024_praktika.model.License;
import ru.mtuci.rbpo_2024_praktika.model.LicenseType;
import ru.mtuci.rbpo_2024_praktika.model.Product;
import ru.mtuci.rbpo_2024_praktika.service.UserService;


import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LicenseService {
    private final ProductService productService;
    private final UserService userService;
    private final LicenseTypeService licenseTypeService;
    public ResponseEntity<?> createLicense(LicenseCreateDto licenseDto){
        Optional<Product> product = productService.getproductById(licenseDto.getProductId());
        if(product.isPresent()){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),"Product ID is not found."),HttpStatus.NOT_FOUND);
        }

        Optional<ApplicationUser> owner = userService.findById(licenseDto.getOwnerId());
        if(owner.isPresent()){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),"Owner is not found."),HttpStatus.NOT_FOUND);
        }

        Optional<LicenseType> licenseType = licenseTypeService.getLicenseTypeByID(licenseDto.getLicenseTypeId());
        if(licenseType.isPresent()){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),"License type is not found."),HttpStatus.NOT_FOUND);
        }

        License license = new License();
        license.setProduct_id(product.get());
        license.setType_id(licenseType.get());
        license.setOwner_id(owner.get());
        license.setCode(UUID.randomUUID().toString());
        license.setDuration(licenseDto.getDuration());
        license.setDevice_count(license.getDevice_count());
        license.setBlocked(false);
        license.setDescription(licenseDto.getDescription());
        return new ResponseEntity<>(license,HttpStatus.CREATED);
    }
}
