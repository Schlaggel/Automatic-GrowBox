package com.example.webApp.controller;

import com.example.webApp.dto.DeviceDTO;
import com.example.webApp.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping("/add")  //todo add  json
    @ResponseBody
    public String addDevice(Authentication auth, @RequestBody DeviceDTO deviceDTO)
    {

        if (deviceDTO.getIdentificator()!= null || deviceDTO.getDescription()!= null){
            deviceService.addDevice(auth.getName(), deviceDTO.getIdentificator(), deviceDTO.getDescription());
            return "true";
        } else {
            return "false";
        }
    }
}
