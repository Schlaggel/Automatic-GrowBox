package com.example.webApp.controller;

import com.example.webApp.connection.Publisher;
import com.example.webApp.dto.UserDTONotLazy;
import com.example.webApp.service.DeviceService;
import com.example.webApp.service.UserService;
import com.example.webApp.util.SettingEsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/setting")
public class SettingController {
    @Autowired
    UserService userService;
    @Autowired
    DeviceService deviceService;
    @Autowired
    private Publisher publisher;

    @GetMapping
    public String deviceInfo(Model model, Authentication auth){
        UserDTONotLazy user =  userService.findByUsername(auth.getName());
        model.addAttribute("devices", user.getDevices());
        return "setting";
    }
    @PostMapping("/hello")
    @ResponseBody
    public String deviceSetting(@RequestBody SettingEsp esp){
        esp.setDeviceIdentificator(deviceService.findIdentificatorByDescription(esp.getDeviceIdentificator()));
        publisher.publish(esp.toString(), "esp32/output");
        return "true"; //todo false
    }
}
