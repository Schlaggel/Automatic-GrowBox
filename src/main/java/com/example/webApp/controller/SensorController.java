package com.example.webApp.controller;

import com.example.webApp.Servie.DeviceService;
import com.example.webApp.Servie.SensorService;
import com.example.webApp.dto.DeviceDTOWithSensors;
import com.example.webApp.dto.SensorDTO;
import com.example.webApp.repository.SensorRepository;
import com.example.webApp.util.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/device/sensor")
public class SensorController {

    @Autowired
    private SensorService sensorService;
    @Autowired
    private DeviceService deviceService;



    @PostMapping("/value")
    public void addValue(SensorDTO sensorDTO, String deviceDescription){
      DeviceDTOWithSensors device =  deviceService.findByDescription(deviceDescription);
      sensorService.addSensor(sensorDTO, device.getDeviceId());
    }

    @PostMapping("/test")
    public String  test(String deviceDescription, String argument, Model model){
        DeviceDTOWithSensors device =  deviceService.findByDescription(deviceDescription);
        List<SensorDTO> sensorDTO = sensorService.searchValues(argument, device.getDeviceId());
        model.addAttribute("surveyMap", sensorDTO);


        return "graph";
    }






}
