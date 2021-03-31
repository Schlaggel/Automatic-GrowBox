package com.example.webApp.controller;

import com.example.webApp.Servie.SensorService;
import com.example.webApp.dto.SensorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.*;

@Controller
public class TestController {

    @Autowired
    private SensorService sensorService;

    @GetMapping("/test")
    public String barGraph(Model model) {

        List<SensorDTO> sensorDTO = sensorService.searchValues("temperature", 26L);
        model.addAttribute("surveyMap", sensorDTO);
        return "test";
    }
}
