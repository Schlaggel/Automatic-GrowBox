package com.example.webApp.repository;

import com.example.webApp.dto.SensorDTO;
import com.example.webApp.util.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
 Sensor findSensorsByDescription(String description);
@Query("from Sensor as s where s.description = :argument and  s.device.deviceId = :id")
  List<Sensor> findByDescriptionAndDevice(@Param("argument") String argument, @Param("id") Long id);

}
