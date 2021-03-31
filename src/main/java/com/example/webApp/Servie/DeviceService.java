package com.example.webApp.Servie;

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


    public void addDevice(DeviceDTOwithUser deviceDTO, String username)
    {
        Device device = modelMapper.map(deviceDTO, Device.class);
           device.setSensors(Collections.emptySet());
           device.setDeviceUser(userRepository.findByUsername(username));
           deviceRepository.save(device);
    }

    public DeviceDTOWithSensors findByDescription(String description){
        return modelMapper.map(deviceRepository.findByDescription(description),
                DeviceDTOWithSensors.class);
    }
}
