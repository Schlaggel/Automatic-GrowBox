package com.example.webApp.controller;


import com.example.webApp.connection.Publisher;
import com.example.webApp.service.DeviceService;
import com.example.webApp.service.SensorService;
import com.example.webApp.dto.DeviceDTOWithSensors;
import com.example.webApp.dto.SensorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/device/sensor")
public class SensorController {

    @Autowired
    private SensorService sensorService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private Publisher publisher;

    @PostMapping("/value")
    @ResponseBody
    public String addValue(SensorDTO sensorDTO, String identificator){
      DeviceDTOWithSensors device =  deviceService.findByIdentificator(identificator);
       // publisher.publish("!");
      sensorService.addSensor(sensorDTO, device.getDeviceId());
      return "true";
    }

    @PostMapping("/test")
    public String  test(String deviceDescription, String argument, Model model){
        DeviceDTOWithSensors device =  deviceService.findByDescription(deviceDescription);
        List<SensorDTO> sensorDTO = sensorService.searchValues(argument, device.getDeviceId());
        model.addAttribute("surveyMap", sensorDTO);
        return "graph";
    }




}
