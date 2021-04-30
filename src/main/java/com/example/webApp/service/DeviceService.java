package com.example.webApp.service;

import com.example.webApp.dto.DeviceDTOWithSensors;
import com.example.webApp.dto.DeviceDTOwithUser;
import com.example.webApp.repository.DeviceRepository;
import com.example.webApp.repository.UserRepository;
import com.example.webApp.util.Device;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;


    public void addDevice(String username, String identifiator, String description)
    {
           Device device = deviceRepository.findByIdentificator(identifiator);
            if(device != null){
                device.setDescription(description);
                device.setDeviceUser(userRepository.findByUsername(username));
                deviceRepository.save(device);
            } else {
                System.out.println("User not found"); //todo Вывести на форму
            }

    }
    public void addDeviceTest(DeviceDTOwithUser deviceDTO, String username, String description)
    {
        Device device = modelMapper.map(deviceDTO, Device.class);
        device.setSensors(Collections.emptySet());
        device.setDescription(description);
        device.setDeviceUser(userRepository.findByUsername(username));
        deviceRepository.save(device);
    }

    public DeviceDTOWithSensors findByDescription(String description){
        return modelMapper.map(deviceRepository.findByDescription(description),
                DeviceDTOWithSensors.class);
    }

    public DeviceDTOWithSensors findByIdentificator(String identificator){
        return modelMapper.map(deviceRepository.findByIdentificator(identificator),
                DeviceDTOWithSensors.class);
    }

    public String findIdentificatorByDescription(String description){
        DeviceDTOWithSensors device = modelMapper.map(deviceRepository.findByDescription(description),
                DeviceDTOWithSensors.class);
        return device.getIdentificator();
    }
}
