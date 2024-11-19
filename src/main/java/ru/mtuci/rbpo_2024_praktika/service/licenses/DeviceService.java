package ru.mtuci.rbpo_2024_praktika.service.licenses;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mtuci.rbpo_2024_praktika.model.ApplicationUser;
import ru.mtuci.rbpo_2024_praktika.model.Device;
import ru.mtuci.rbpo_2024_praktika.repository.DeviceRepository;

@RequiredArgsConstructor
@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

//    public Device registerOrUpdateDevice(Device device, ApplicationUser user){
//        if(deviceRepository.findById(device.getId()).isPresent()){
//            deviceRepository.save()
//        }
//    }
}
