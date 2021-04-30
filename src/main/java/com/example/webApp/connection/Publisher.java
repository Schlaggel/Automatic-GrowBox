package com.example.webApp.connection;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
    public void publish(String messageString, String topic){
        try(MqttClient client = new MqttClient("tcp://127.0.0.1:1883", "Publisher")) {
           // MqttClient client = new MqttClient("tcp://127.0.0.1:1883", "Publisher");
            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(false);
            options.setConnectionTimeout(10);
            client.connect(options);
            MqttMessage message = new MqttMessage();
            message.setPayload(messageString
                    .getBytes());
            client.publish(topic, message);
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
