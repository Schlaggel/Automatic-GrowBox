package com.example.webApp.controller;

import com.example.webApp.Servie.DeviceService;
import com.example.webApp.Servie.SensorService;
import com.example.webApp.Servie.UserService;
import com.example.webApp.dto.DeviceDTOWithSensors;
import com.example.webApp.dto.SensorDTO;
import com.example.webApp.dto.UserDTONotLazy;
import com.example.webApp.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private SensorService sensorService;

    @GetMapping
    public String userForm(
        Authentication auth, Model model, String deviceDescription, String argument) {
        UserDTONotLazy user =  userService.findByUsername(auth.getName());

        List<Long> deviceId = null;
        DeviceDTOWithSensors device = null;

        if (user.getDevices().isEmpty()){
                 deviceId = user.getDevices()
                .stream()
                .map(DeviceDTOWithSensors::getDeviceId)
                .collect(Collectors.toList());
             Collections.sort(deviceId);
        }

        model.addAttribute("devices", user.getDevices());
        model.addAttribute("deviceId", deviceId);
        model.addAttribute("name", auth.getName());
        model.addAttribute("user", user);

        if (deviceDescription != null){
             device =  deviceService.findByDescription(deviceDescription);
             List<SensorDTO> sensorDTO = sensorService.searchValues(argument, device.getDeviceId());
             model.addAttribute("surveyMap", sensorDTO);
       }
        return "user";
    }
}



