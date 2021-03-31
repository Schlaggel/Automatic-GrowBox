package com.example.webApp.Servie;


import com.example.webApp.dto.SensorDTO;
import com.example.webApp.repository.DeviceRepository;
import com.example.webApp.repository.SensorRepository;
import com.example.webApp.util.Sensor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SensorService {

    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private SensorRepository sensorRepository;
    @Autowired
    private ModelMapper modelMapper;


    public void addSensor(SensorDTO sensorDTO, Long deviceId)
    {
        Sensor sensor = modelMapper.map(sensorDTO, Sensor.class);
        sensor.setDevice(deviceRepository.findDeviceByDeviceId(deviceId));
        sensorRepository.save(sensor);
    }

    public List<SensorDTO> searchValues(String argument, Long deviceId)
    {
        return sensorRepository.findByDescriptionAndDevice(argument, deviceId)
                .stream()
                .map(sensor -> modelMapper.map(sensor, SensorDTO.class))
                .collect(Collectors.toList());
    }
}
