package com.example.webApp.util;

public class SettingEsp {

    private String deviceIdentificator;
    private String temperature;
    private String humidity;
    private String aeration;
    private String flooding;
    private String time_first;
    private String time_second;

    public String getDeviceIdentificator() {
        return deviceIdentificator;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getAeration() {
        return aeration;
    }

    public String getFlooding() {
        return flooding;
    }

    public String getTime_first() {
        return time_first;
    }

    public String getTime_second() {
        return time_second;
    }

    public void setDeviceIdentificator(String deviceIdentificator) {
        this.deviceIdentificator = deviceIdentificator;
    }

    @Override
    public String toString() {
        return "{" +
                "deviceIdentificator: '" + deviceIdentificator + '\'' +
                ", temperature: '" + temperature + '\'' +
                ", humidity: '" + humidity + '\'' +
                ", aeration: '" + aeration + '\'' +
                ", flooding: '" + flooding + '\'' +
                ", time_first: '" + time_first + '\'' +
                ", time_second: '" + time_second + '\'' +
                '}';
    }
}
