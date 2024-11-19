package ru.mtuci.rbpo_2024_praktika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtuci.rbpo_2024_praktika.model.Device;

import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {

}
