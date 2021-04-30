package com.example.webApp.connection;

import com.example.webApp.dto.DeviceDTO;
import com.example.webApp.dto.DeviceDTOWithSensors;
import com.example.webApp.dto.SensorDTO;
import com.example.webApp.service.DeviceService;
import com.example.webApp.service.SensorService;
import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Order(Ordered.LOWEST_PRECEDENCE)
public class Subscriber implements MqttCallback {
    @Autowired
    private SensorService sensorService;
    @Autowired
    private DeviceService deviceService;

    public Subscriber() {
    }

    @PostConstruct
    public void exec() {
        try {
            MqttClient client = new MqttClient("tcp://127.0.0.1:1883", "Sending");
            client.setCallback(this);
            client.connect();
            client.subscribe("esp32/temperature");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("ERROR!");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        JSONObject obj = new JSONObject(message.toString());
        Integer value = obj.getInt("value");
        String identificator = obj.getString("identificator");
        String description = obj.getString("description");
        DeviceDTOWithSensors deviceDTO = deviceService.findByIdentificator(identificator);
        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setValue(value);
        sensorDTO.setDescription(description);
        sensorService.addSensor(sensorDTO, deviceDTO.getDeviceId());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}