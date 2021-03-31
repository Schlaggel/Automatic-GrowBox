package com.example.webApp.dto;

import java.util.Set;

public class DeviceDTOWithSensors {

    private Long deviceId;
    private boolean isEnable;
    private String description;

    private Set<SensorDTO> sensors;


    public DeviceDTOWithSensors() {
        isEnable = true;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
       isEnable = enable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<SensorDTO> getSensors() {
        return sensors;
    }

    public void setSensors(Set<SensorDTO> sensors) {
        this.sensors = sensors;
    }

    @Override
    public String toString() {
        return "id: " + deviceId + " name: " +  description + '\'';
    }
}
