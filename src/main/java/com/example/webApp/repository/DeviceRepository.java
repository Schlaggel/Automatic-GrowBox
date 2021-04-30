package com.example.webApp.repository;

import com.example.webApp.util.Device;
import com.example.webApp.util.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device, Long> {
  Device findDeviceByDeviceId(Long deviceId);

  Device findByDescription(String description);

  Device findByIdentificator(String identificator);
}
