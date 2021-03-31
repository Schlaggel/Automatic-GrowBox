package com.example.webApp.controller;

import com.example.webApp.Servie.DeviceService;
import com.example.webApp.dto.DeviceDTOwithUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping("/add")
    public String addDevice(DeviceDTOwithUser deviceDTO, Authentication auth)
    {
            deviceService.addDevice(deviceDTO,auth.getName());
            return "redirect:/user";
    }

}
