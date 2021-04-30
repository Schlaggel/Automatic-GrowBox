package com.example.webApp.util;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;


@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private Long deviceId;

    private boolean isEnable;

    private String description;

    private String identificator;


    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
    @JoinColumn(name="user_id") //nullable=false
    private User deviceUser;

    @OneToMany(mappedBy = "device", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Sensor> sensors = Collections.emptySet();

    public Device() {

    }

    public Device(Long id, String description) {
        this.deviceId = id;
        this.description = description;
    }

    public Device(String description) {
        this.description = description;
    }

    public Device( boolean isEnable, String description, User user) {
        this.isEnable = isEnable;
        this.description = description;
        this.deviceUser = user;
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

    public User getDeviceUser() {
        return deviceUser;
    }

    public void setDeviceUser(User deviceUser) {
        this.deviceUser = deviceUser;
    }

    public Set<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(Set<Sensor> sensors) {
        this.sensors = sensors;
    }

    public String getIdentificator() {
        return identificator;
    }

    public void setIdentificator(String identificator) {
        this.identificator = identificator;
    }
}




